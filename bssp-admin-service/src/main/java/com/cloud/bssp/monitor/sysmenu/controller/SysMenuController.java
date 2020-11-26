package com.cloud.bssp.monitor.sysmenu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.monitor.sysmenu.entity.SysMenuDO;
import com.cloud.bssp.monitor.sysmenu.dto.SysMenuDTO;
import com.cloud.bssp.monitor.sysmenu.service.SysMenuService;
import com.cloud.bssp.monitor.sysmenu.convert.SysMenuDoConvert;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * SysMenu Controller控制器
 * </p>
 *
 * @author weirx
 * @since 2020-07-13
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("/sysmenu")
@AllArgsConstructor
public class SysMenuController {

    /**
     * SysMenuService
     */
    private SysMenuService sysMenuService;

    /**
     * 分页列表
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody SysMenuDTO sysMenuDTO) {
        QueryWrapper<SysMenuDO> queryWrapper = new QueryWrapper<>(SysMenuDoConvert.dtoToDo(sysMenuDTO));
        Page<SysMenuDO> page = new Page<>(sysMenuDTO.getPage(), sysMenuDTO.getLimit());
        Page<SysMenuDO> pageList = sysMenuService.page(page, queryWrapper);
        return R.success(SysMenuDoConvert.pageConvert(pageList));
    }

    /**
     * list列表
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")
    public R list(@RequestBody SysMenuDTO sysMenuDTO) {
        QueryWrapper<SysMenuDO> queryWrapper = new QueryWrapper<>(SysMenuDoConvert.dtoToDo(sysMenuDTO));
        List<SysMenuDO> sysMenuList = sysMenuService.list(queryWrapper);
        return R.success(SysMenuDoConvert.listConvert(sysMenuList));
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public R info(@RequestParam("id") Long id) {
        SysMenuDO sysMenu = sysMenuService.getById(id);
        return R.success(SysMenuDoConvert.doToDto(sysMenu));
    }

    /**
     * 新增
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody SysMenuDTO sysMenuDTO) {
        boolean flag = sysMenuService.save(SysMenuDoConvert.dtoToDo(sysMenuDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     * @param sysMenuDTO
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody SysMenuDTO sysMenuDTO) {
        boolean flag = sysMenuService.updateById(SysMenuDoConvert.dtoToDo(sysMenuDTO));
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
