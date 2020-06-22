package com.cloud.bssp.data.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * Description: TODO description
 * Create Date: 2020/6/22
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
public class PageUtil extends Page {

    public static Page getPageInfo(Map<String, Object> map) {
        Page page = new Page(
                map.get("offset") == null ? 0 : Integer.valueOf(map.get("offset").toString()),
                map.get("limit") == null ? 10 : Integer.valueOf(map.get("limit").toString()));
        return page;
    }
}
