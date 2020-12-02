package com.cloud.bssp.admin.sysmenu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.bssp.admin.sysmenu.entity.SysMenuDO;
import com.cloud.bssp.admin.sysmenu.mapper.SysMenuMapper;
import com.cloud.bssp.admin.sysmenu.service.SysMenuService;
import com.cloud.bssp.constants.SystemConstant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Module: SysMenuServiceImpl.java
 *
 * @author weirx
 * @version 1.0
 * @date 2020-06-22
 * @Descriptions:
 * @since JDK 1.8
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements SysMenuService {

    /**
     * 菜单mapper
     */
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Map<String, Object>> getTree() {
        SysMenuDO sysMenuDO = new SysMenuDO();
        sysMenuDO.setIsEnable(SystemConstant.ONE);
        sysMenuDO.setIsDelete(SystemConstant.ZERO);
        QueryWrapper<SysMenuDO> queryWrapper = new QueryWrapper<>(sysMenuDO);
        queryWrapper.orderByAsc("id");
        List<SysMenuDO> sysMenuDOS = sysMenuMapper.selectList(queryWrapper);
        List<Map<String, Object>> list = new ArrayList<>();
        //获取所有父节点
        for (SysMenuDO s : sysMenuDOS) {
            if (s.getParentId() == 0) {
                list.add(this.getChildren(s));
            }
        }
        //获取所有子节点
        for (Map<String, Object> map : list) {
            map.put("children", this.getChildrenList(map.get("id").toString(), sysMenuDOS));
        }
        return list;
    }

    /**
     * @description: 根据父节点获取子节点
     *
     * @param parentId
     * @param list
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author weirx
     * @date 2020/6/24
     */
    public List<Map<String, Object>> getChildrenList(String parentId, List<SysMenuDO> list) {
        List<Map<String, Object>> childrenList = new ArrayList<>();
        Map<String, Object> children;
        for (SysMenuDO sysMenuDO : list) {
            if (sysMenuDO.getParentId().toString().equals(parentId)) {
                children = this.getChildren(sysMenuDO);
                childrenList.add(children);
            }
        }
        return childrenList;
    }

    /**
     * @description: 组装数据
     *
     * @param s
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author weirx
     * @date 2020/6/24
     */
    public Map<String, Object> getChildren(SysMenuDO s) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", s.getId());
        map.put("label", s.getLabel());
        map.put("path", s.getPath());
        map.put("icon", s.getIcon());
        map.put("parentId", s.getParentId());
        map.put("isPublic", s.getIsPublic());
        map.put("sort", s.getSortValue());
        map.put("component", s.getComponent());
        return map;
    }
}
