package com.cloud.bssp.generator.util;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;


@Component
public class GenComp {

    @Autowired
    private GenMapper genMapper;

    /**
     * 生成所有表
     *
     * @return
     */
    public byte[] generatorCode(String author, String packageName) {
        List<String> tableNames = genMapper.queryAllTable();
        return generatorCode(tableNames, author, packageName);
    }

    /**
     * 生成指定表
     *
     * @param tableNames
     * @return
     */
    public byte[] generatorCode(List<String> tableNames, String author, String packageName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            Map<String, Object> table = genMapper.queryTable(tableName);
            List<Map<String, Object>> columns = genMapper.queryColumns(tableName);
            GenUtils.generatorCode(table, columns, zip, author, packageName);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

}