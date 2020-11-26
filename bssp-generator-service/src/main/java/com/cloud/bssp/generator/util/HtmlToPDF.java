package com.cloud.bssp.generator.util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.itextpdf.text.*;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * html转PDF工具类
 *
 * @author zql
 *
 */
@Slf4j
public class HtmlToPDF {


    /**
     * html模板生成PDF文件输出
     * 此方法需要maven支持如下：
     * <br/>
     * &lt;dependency>
     * <br/>
     * &lt;groupId>org.xhtmlrenderer&lt;/groupId>
     * <br/>
     * &lt;artifactId>core-renderer&lt;/artifactId>
     * <br/>
     * &lt;version>R8&lt;/version>
     * <br/>
     * &lt;/dependency>
     *
     * @param htmlPath html模板文件路径
     * @param map 要替换的字段值
     * @param pdfPath pdf输出路径
     * @throws Exception
     */
    public static void generatePdf(String htmlPath, Map<String, String> map, String pdfPath) throws Exception {
        try {
            OutputStream outputFile = new FileOutputStream(pdfPath);
            // 获取html String形式
            String htmlStr = operateHtml(htmlPath, map);

            ITextRenderer renderer = new ITextRenderer();

            ITextFontResolver font = renderer.getFontResolver();

            String sysPath = System.getProperty("user.dir");
            String fontPath = sysPath + "\\src\\fonts\\simsun.ttc";
            // 添加中文识别，这里是设置的宋体，Linux下要换成对应的字体，中文不显示则给不显示的标签加上样式font-family:'SimSun';
            font.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.setDocumentFromString(htmlStr);

            renderer.layout();
            renderer.createPDF(outputFile);
            renderer.finishPDF();
            log.info("PDF is generate.------------------------------");
        } catch (IOException e) {
            log.info("HtmlToPDF.generatePdf occoured IOException! Message:" + e.getMessage());
            throw e;
        } catch (DocumentException e) {
            log.info("HtmlToPDF.generatePdf occoured DocumentException! Message:" + e.getMessage());
            throw e;
        }
    }

    public static ByteArrayOutputStream generatePdfByHtml(String htmlStr) throws Exception {
        htmlStr = htmlStr.replaceAll("<br>", "</br>");
        htmlStr = htmlStr.replaceAll("png\">", "png\"/>");
        htmlStr = htmlStr.replaceAll("jpg\">", "jgp\"/>");
        htmlStr = htmlStr.replaceAll("image\">", "image\"/>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        //获取字体文件目录
        // 设置中文字体/宋体// 设置中文字体
        fontResolver.addFont("SimSun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.getSharedContext().setReplacedElementFactory(new Base64ImgReplacedElementFactory());
        renderer.setDocumentFromString(htmlStr);
        renderer.layout();
        renderer.createPDF(byteArrayOutputStream);
        renderer.finishPDF();
        log.info("PDF is generate.------------------------------");
        return byteArrayOutputStream;
    }

    /**
     * html模板生成PDF文件输出
     *
     * @param htmlStr html模板文件路径
     * @throws Exception
     */
    public static ByteArrayOutputStream generatePdf(String htmlStr) throws Exception {
        htmlStr = htmlStr.replaceAll("<br>", "</br>");
        htmlStr = htmlStr.replaceAll("png\">", "png\"/>");
        htmlStr = htmlStr.replaceAll("jpg\">", "jgp\"/>");
        htmlStr = htmlStr.replaceAll("image\">", "image\"/>");
        Document document = new Document();

        OutputStream outputStream = new FileOutputStream("D:/pdf.pdf");
        PdfWriter writer;
        writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        InputStream bis = new ByteArrayInputStream(htmlStr.getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, bis);

        return null;
    }

    /**
     * String转InputStream
     *
     * @param str
     * @return
     */
    private static InputStream stringToInputStream(String str) {
        InputStream in = new ByteArrayInputStream(str.getBytes());
        return in;
    }

    /**
     * InputStream转String
     *
     * @param in
     * @return
     */
    @SuppressWarnings("unused")
    private static String inputStreamToString(InputStream in) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = 1;
        try {
            while ((i = in.read()) != -1) {
                baos.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos.toString();
    }

    /**
     * 读取html模板文件并替换参数值
     *
     * @param htmlPath html文件路径
     * @param map 要替换的参数值
     * @return
     * @throws Exception
     */
    private static String operateHtml(String htmlPath, Map<String, String> map) throws Exception {
        // html字符串
        String htmlStr = "";
        File htmlFile = null;
        try {
            htmlFile = new File(htmlPath);

            //获取htmlStr jsoup,建议使用，会补全缺失的</**>
            org.jsoup.nodes.Document html = Jsoup.parse(htmlFile, "UTF-8");
            htmlStr = html.html();

            // 解决中文问题
            htmlStr = htmlStr.replaceAll("font-family:[^;]*;", "font-family:'SimSun';");

            // 解决docx中文问题
            htmlStr = htmlStr.replaceAll("width:[^;]*;", "");
            htmlStr = htmlStr.replaceAll("margin-bottom:[^;]*;", "");
            htmlStr = htmlStr.replaceAll("margin-left:[^;]*;", "");
            htmlStr = htmlStr.replaceAll("margin-right:[^;]*;", "");
            htmlStr = htmlStr.replaceAll("margin-top:[^;]*;", "");
            htmlStr = htmlStr.replaceAll("p\\.[^\\}]*\\}", "");
            htmlStr = htmlStr.replaceAll("span\\.[^\\}]*\\}", "");
            htmlStr = htmlStr.replaceAll("<p>", "<p style = \"font-family:'SimSun';\">");

            //将未闭合的<meta>标签 闭合
            htmlStr = expectedClosingTag(htmlStr, "(<META[^>]*[^/]>)|(<meta[^>]*[^/]>)");

            //表格线条错误粗修改
            htmlStr = htmlStr.replaceAll("thin solid black", "1");

            //替换特殊字段   字段形式 如： ${test}
            for (Map.Entry<String, String> entry : map.entrySet()) {
                htmlStr = htmlStr.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
                htmlStr = htmlStr.replaceAll("\\$\\{[^\\}]*" + entry.getKey() + "[^\\}]*\\}", entry.getValue());
            }

            // 将未赋值的去除
            htmlStr = htmlStr.replaceAll("\\$\\{[^\\}]*[^\\}]*\\}", "&nbsp;&nbsp;&nbsp;&nbsp;");
            // 将body标签内样式去掉，并加上font-family:'SimSun';解决中文不显示问题
            htmlStr = htmlStr.replaceAll("<body[^>]*>", "<body style=\"font-family:'SimSun';\">");
        } catch (Exception e) {
            log.info("HtmlToPDF.operateHtml occoured Exception! Message:" + e.getMessage());
            throw e;
        } finally {
            if (htmlFile != null) {
                htmlFile.delete();
            }
        }
        return htmlStr;
    }

    /**
     * 处理html meta标签，使meta标签闭合
     * @param htmlStr
     * @param regex
     * @return
     */
    private static String expectedClosingTag(String htmlStr, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(htmlStr);
        List<String> result = new ArrayList<String>();
        while (m.find()) {
            result.add(m.group());
        }
        for (String str : result) {
            int strLen = str.length();
            if (str != null && strLen > 1) {
                log.debug("In need of replacement:" + str);
                htmlStr = htmlStr.replace(str, str.substring(0, strLen - 1) + "/>");
            }
        }
        return htmlStr;
    }

    /**
     * 获取当前操作系统
     *
     * @return
     */
    public static String getCurrentOperatingSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        log.debug("---------当前操作系统是-----------" + os);
        return os;
    }


}