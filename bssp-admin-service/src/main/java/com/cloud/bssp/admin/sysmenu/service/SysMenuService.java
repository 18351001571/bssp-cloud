package com.cloud.bssp.admin.sysmenu.service;

import com.cloud.bssp.admin.config.IDataService;
import com.cloud.bssp.admin.sysmenu.entity.SysMenuDO;

import java.util.List;
import java.util.Map;

/**
 * Module: SysMenuService.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-06-22
 * @Descriptions:
 */
public interface SysMenuService extends IDataService<SysMenuDO> {
    /**
     * description: 获取树形结构菜单
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author weirx
     * @date 2020/6/24
     */
    List<Map<String, Object>> getTree();
}