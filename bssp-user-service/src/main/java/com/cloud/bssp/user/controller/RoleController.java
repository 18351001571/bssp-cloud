package com.cloud.bssp.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.user.entity.RoleDO;
import com.cloud.bssp.user.dto.RoleDTO;
import com.cloud.bssp.user.service.RoleService;
import com.cloud.bssp.user.convert.RoleDoConvert;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * Create Date: 2020-07-23T14:46:53.286
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Api(tags = "")
@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    /**
     * RoleService
     */
    private RoleService roleService;

    /**
     * 分页列表
     * @param roleDTO
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody RoleDTO roleDTO) {
        QueryWrapper<RoleDO> queryWrapper = new QueryWrapper<>(RoleDoConvert.dtoToDo(roleDTO));
        Page<RoleDO> page = new Page<>(roleDTO.getPage(), roleDTO.getLimit());
        Page<RoleDO> pageList = roleService.page(page, queryWrapper);
        return R.success(RoleDoConvert.pageConvert(pageList));
    }

    /**
     * list列表
     * @param roleDTO
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")
    public R list(@RequestBody RoleDTO roleDTO) {
        QueryWrapper<RoleDO> queryWrapper = new QueryWrapper<>(RoleDoConvert.dtoToDo(roleDTO));
        List<RoleDO> roleList = roleService.list(queryWrapper);
        return R.success(RoleDoConvert.listConvert(roleList));
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public R info(@RequestParam("id") Long id) {
        RoleDO role = roleService.getById(id);
        return R.success(RoleDoConvert.doToDto(role));
    }

    /**
     * 新增
     * @param roleDTO
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody RoleDTO roleDTO) {
        boolean flag = roleService.save(RoleDoConvert.dtoToDo(roleDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     * @param roleDTO
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody RoleDTO roleDTO) {
        boolean flag = roleService.updateById(RoleDoConvert.dtoToDo(roleDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 根据用户id查询角色list
     * @param userId
     * @return
     */
    @ApiOperation(value = "根据用户id查询角色list")
    @GetMapping("/getByUserId")
    public R getByUserId(@RequestParam("userId") Long userId) {
        RoleDO role = roleService.getByUserId(userId);
        return R.success(RoleDoConvert.doToDto(role));
    }
}
