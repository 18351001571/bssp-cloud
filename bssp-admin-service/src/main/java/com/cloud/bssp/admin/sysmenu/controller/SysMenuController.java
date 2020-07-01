package com.cloud.bssp.admin.sysmenu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.cloud.bssp.admin.sysmenu.entity.SysMenuDO;
import com.cloud.bssp.admin.sysmenu.dto.SysMenuDTO;
import com.cloud.bssp.admin.sysmenu.service.SysMenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * SysMenu Controller控制器
 * </p>
 *
 * @author weirx
 * @since 2020-06-24
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {

    /**
     * SysMenuService
     */
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 分页列表
     *
     * @param params
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody Map<String, Object> params) {
        QueryWrapper<SysMenuDO> queryWrapper = new QueryWrapper<>();
        //默认按照id倒序
        queryWrapper.orderByDesc("id");
        Page<SysMenuDO> page = new Page<>(
                params.get("page") == null ? 0 : Integer.valueOf(params.get("page").toString()),
                params.get("limit") == null ? 10 : Integer.valueOf(params.get("limit").toString()));
        Page<SysMenuDO> pageList = sysMenuService.page(page, queryWrapper);
        List<SysMenuDTO> list = new ArrayList<>();
        SysMenuDTO sysMenuDTO;
        for (SysMenuDO sysMenuDO : pageList.getRecords()) {
            sysMenuDTO = new SysMenuDTO();
            BeanCopierUtil.copy(sysMenuDO, sysMenuDTO);
            list.add(sysMenuDTO);
        }
        Page<SysMenuDTO> dtoList = new Page<>(pageList.getCurrent(), pageList.getSize(), pageList.getTotal());
        dtoList.setRecords(list);
        return R.success(dtoList);
    }

    /**
     * list列表
     *
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")
    public R list(@RequestBody SysMenuDTO sysMenuDTO) {
        SysMenuDO sysMenuDO = new SysMenuDO();
        BeanCopierUtil.copy(sysMenuDTO, sysMenuDO);
        QueryWrapper<SysMenuDO> queryWrapper = new QueryWrapper<>(sysMenuDO);
        List<SysMenuDO> sysMenuList = sysMenuService.list(queryWrapper);
        List<SysMenuDTO> list = new ArrayList<>();
        for (SysMenuDO sysMenu : sysMenuList) {
            sysMenuDTO = new SysMenuDTO();
            BeanCopierUtil.copy(sysMenu, sysMenuDTO);
            list.add(sysMenuDTO);
        }
        return R.success(list);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public R info(@RequestParam("id") Long id) {
        SysMenuDO sysMenu = sysMenuService.getById(id);
        SysMenuDTO sysMenuDTO = new SysMenuDTO();
        if (!ObjectUtils.isEmpty(sysMenu)) {
            BeanCopierUtil.copy(sysMenu, sysMenuDTO);
        }
        return R.success(sysMenuDTO);
    }

    /**
     * 新增
     *
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody SysMenuDTO sysMenuDTO) {
        SysMenuDO sysMenuDO = new SysMenuDO();
        BeanCopierUtil.copy(sysMenuDTO, sysMenuDO);
        boolean flag = sysMenuService.save(sysMenuDO);
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     *
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody SysMenuDTO sysMenuDTO) {
        SysMenuDO sysMenuDO = new SysMenuDO();
        BeanCopierUtil.copy(sysMenuDTO, sysMenuDO);
        boolean flag = sysMenuService.updateById(sysMenuDO);
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 获取树形菜单
     *
     * @return
     */
    @ApiOperation(value = "获取树形菜单")
    @GetMapping("/getTree")
    public R getTree() {
        List<Map<String, Object>> menuList = sysMenuService.getTree();
        return R.success(menuList);
    }
}