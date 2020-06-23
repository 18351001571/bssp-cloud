package com.cloud.bssp.data.sysmenu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.data.sysmenu.dto.SysMenuDTO;
import com.cloud.bssp.data.sysmenu.entity.SysMenuDO;
import com.cloud.bssp.data.sysmenu.service.SysMenuService;
import com.cloud.bssp.data.util.PageUtil;
import com.cloud.bssp.util.BeanCopierUtil;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * SysMenu Controller控制器
 * </p>
 *
 * @author weirx
 * @since 2020-06-22
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
        Page<SysMenuDO> page = PageUtil.getPageInfo(params);
        Page<SysMenuDO> pageList = sysMenuService.page(page, queryWrapper);
        List<SysMenuDO> records = pageList.getRecords();
        List<SysMenuDTO> list = new ArrayList<>();
        records.forEach(r -> {
            SysMenuDTO sysMenuDTO = new SysMenuDTO();
            BeanCopierUtil.copy(r, sysMenuDTO);
            list.add(sysMenuDTO);
        });
        Page<SysMenuDTO> dtoList = new Page<>();
        dtoList.setRecords(list);
        dtoList.setTotal(pageList.getTotal());
        dtoList.setCurrent(pageList.getCurrent());
        dtoList.setSize(pageList.getSize());
        return R.success(dtoList);
    }

    /**
     * list列表
     *
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")
    public R list(@RequestBody SysMenuDO sysMenu) {
        QueryWrapper<SysMenuDO> queryWrapper = new QueryWrapper<>(sysMenu);
        List<SysMenuDO> sysMenuList = sysMenuService.list(queryWrapper);
        return R.success(sysMenuList);
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
        return R.success(sysMenu);
    }

    /**
     * 新增
     *
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody SysMenuDO sysMenu) {
        boolean flag = sysMenuService.save(sysMenu);
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     *
     * @param sysMenu
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody SysMenuDO sysMenu) {
        boolean flag = sysMenuService.updateById(sysMenu);
        if (flag) {
            return R.success();
        }
        return R.failed();
    }
}