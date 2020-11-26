package com.cloud.bssp.generator.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.generator.entity.TableColumnDO;
import com.cloud.bssp.generator.entity.TableDO;
import com.cloud.bssp.generator.service.ReportService;
import com.cloud.bssp.generator.util.CommonMap;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Description: 报表service
 * Create Date: 2020/7/30
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
@Service
public class ReportServiceImpl implements ReportService {

    private List<File> staticFiles;


    @Override
    public ByteArrayOutputStream reportHtml(String html) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        this.htmlHandler(zip, html);
        IOUtils.closeQuietly(zip);
        return outputStream;
    }

    @Override
    public ByteArrayOutputStream getHtml(String html) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        // 封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("title", "资产指纹全貌统计报告");
        map.put("template", html);

        VelocityContext context = new VelocityContext(map);

        // 获取模板列表
        List<String> templates = getHtmlTemplates();
        Map<String, Object> dataMap = new LinkedHashMap<>();
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            dataMap.put(template, sw);
            try {
                // 添加到zip
                IOUtils.write(sw.toString(), byteArrayOutputStream, "UTF-8");
                IOUtils.closeQuietly(sw);
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream;
    }

    private void htmlHandler(ZipOutputStream zip, String html) throws IOException {
        // 设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        // 封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("title", "资产指纹全貌统计报告");
        map.put("template", html);

        VelocityContext context = new VelocityContext(map);

        // 获取模板列表
        List<String> templates = getHtmlTemplates();
        Map<String, Object> dataMap = new LinkedHashMap<>();
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            dataMap.put(template, sw);
            try {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(getHtmlToPdf(template)));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String path = "template" + File.separator + "report" + File.separator + "static";
        staticFiles = new ArrayList<>();
        this.getFile(path);
        InputStream inputStream;
        for (File file : staticFiles) {
            inputStream = new FileInputStream(file);
            ZipEntry entry = new ZipEntry(file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("report")));
            zip.putNextEntry(entry);
            // 写入当前条目所对应的具体内容
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) != -1) {
                zip.write(buff, 0, len);
            }
            inputStream.close();
        }
        zip.closeEntry();
        zip.close();
    }

    public void getFile(String filePath) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:" + filePath);
        File[] files = file.listFiles();
        // 目录下文件
        if (files.length == 0) {
            System.out.println(file + "该文件夹下没有文件");
        }
        // 存在文件 遍历 判断
        for (File f : files) {
            // 判断是否为 文件夹
            if (f.isDirectory()) {
                // 为 文件夹继续遍历
                getFile(f.getAbsolutePath().substring(f.getAbsolutePath().indexOf("template")));
                // 判断是否为 文件
            } else if (f.isFile()) {
                staticFiles.add(f);
            }
        }
    }

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("template/Report.html.vm");
        return templates;
    }

    public static List<String> getHtmlTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("template/HtmlToPdf.html.vm");
        return templates;
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template) {
        if (template.contains("Report.html.vm")) {
            return "report" + File.separator + "Report.html";
        }
        return null;
    }

    /**
     * 获取文件名
     */
    public static String getHtmlToPdf(String template) {
        if (template.contains("HtmlToPdf.html.vm")) {
            return "report" + File.separator + "HtmlToPdf.html";
        }
        return null;
    }
}
