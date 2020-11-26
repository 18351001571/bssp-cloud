package com.cloud.bssp.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.user.entity.UserRoleDO;
import com.cloud.bssp.user.dto.UserRoleDTO;
import com.cloud.bssp.user.service.UserRoleService;
import com.cloud.bssp.user.convert.UserRoleDoConvert;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: 用户角色关系表
 * Create Date: 2020-07-23T14:46:56.062
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Api(tags = "用户角色关系表")
@RestController
@RequestMapping("/userrole")
@AllArgsConstructor
public class UserRoleController {

    /**
     * UserRoleService
     */
    private UserRoleService userRoleService;

    /**
     * 分页列表
     * @param userRoleDTO
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody UserRoleDTO userRoleDTO) {
        QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>(UserRoleDoConvert.dtoToDo(userRoleDTO));
        Page<UserRoleDO> page = new Page<>(userRoleDTO.getPage(), userRoleDTO.getLimit());
        Page<UserRoleDO> pageList = userRoleService.page(page, queryWrapper);
        return R.success(UserRoleDoConvert.pageConvert(pageList));
    }

    /**
     * list列表
     * @param userRoleDTO
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")
    public R list(@RequestBody UserRoleDTO userRoleDTO) {
        QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>(UserRoleDoConvert.dtoToDo(userRoleDTO));
        List<UserRoleDO> userRoleList = userRoleService.list(queryWrapper);
        return R.success(UserRoleDoConvert.listConvert(userRoleList));
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public R info(@RequestParam("id") Long id) {
        UserRoleDO userRole = userRoleService.getById(id);
        return R.success(UserRoleDoConvert.doToDto(userRole));
    }

    /**
     * 新增
     * @param userRoleDTO
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody UserRoleDTO userRoleDTO) {
        boolean flag = userRoleService.save(UserRoleDoConvert.dtoToDo(userRoleDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     * @param userRoleDTO
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody UserRoleDTO userRoleDTO) {
        boolean flag = userRoleService.updateById(UserRoleDoConvert.dtoToDo(userRoleDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }
}
