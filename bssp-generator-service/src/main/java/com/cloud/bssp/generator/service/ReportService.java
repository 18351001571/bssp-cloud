package com.cloud.bssp.generator.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Description: 报表service
 * Create Date: 2020/7/15
 * Modified By：
 * Modified Date：
 * Why &amp; What is modified：
 * Copyright (C) 2020 mvtech.com.cn All Right Reserved.
 * @author weirx
 * @version 1.0
 */
public interface ReportService {

    /**
     * html导出
     * @param html
     * @return
     */
    ByteArrayOutputStream reportHtml(String html) throws IOException;

    /**
     * 获取html
     * @param html
     * @return
     */
    ByteArrayOutputStream getHtml(String html) throws IOException;
}
