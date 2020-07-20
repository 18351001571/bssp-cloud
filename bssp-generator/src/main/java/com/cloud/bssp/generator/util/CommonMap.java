package com.cloud.bssp.generator.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共map
 *
 * @author weirx
 * @date 2020-07-17
 */
public class CommonMap {
    /**
     * 状态编码转换
     */
    public static Map<String, String> javaTypeMap = new HashMap<String, String>();

    static {
        initJavaTypeMap();
    }

    /**
     * 返回状态映射
     */
    public static void initJavaTypeMap() {
        javaTypeMap.put("tinyint", "Integer");
        javaTypeMap.put("smallint", "Integer");
        javaTypeMap.put("mediumint", "Integer");
        javaTypeMap.put("int", "Integer");
        javaTypeMap.put("integer", "integer");
        javaTypeMap.put("bigint", "Long");
        javaTypeMap.put("float", "Float");
        javaTypeMap.put("double", "Double");
        javaTypeMap.put("decimal", "Double");
        javaTypeMap.put("bit", "Boolean");
        javaTypeMap.put("char", "String");
        javaTypeMap.put("varchar", "String");
        javaTypeMap.put("tinytext", "String");
        javaTypeMap.put("text", "String");
        javaTypeMap.put("mediumtext", "String");
        javaTypeMap.put("longtext", "String");
        javaTypeMap.put("time", "LocalDateTime");
        javaTypeMap.put("date", "LocalDate");
        javaTypeMap.put("datetime", "LocalDateTime");
        javaTypeMap.put("timestamp", "LocalDateTime");
        javaTypeMap.put("jdk", "1.8");
        javaTypeMap.put("version", "1.0");
    }
}