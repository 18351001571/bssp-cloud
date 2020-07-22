package com.cloud.bssp.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.user.entity.UserDO;
import com.cloud.bssp.user.dto.UserDTO;
import com.cloud.bssp.user.service.UserService;
import com.cloud.bssp.user.convert.UserDoConvert;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: 用户表
 * Create Date: 2020-07-22T16:35:33.892
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Api(tags = "用户表")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    /**
     * UserService
     */
    private UserService userService;

    /**
     * 分页列表
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody UserDTO userDTO) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>(UserDoConvert.dtoToDo(userDTO));
        Page<UserDO> page = new Page<>(userDTO.getPage(), userDTO.getLimit());
        Page<UserDO> pageList = userService.page(page, queryWrapper);
        return R.success(UserDoConvert.pageConvert(pageList));
    }

    /**
     * list列表
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")
    public R list(@RequestBody UserDTO userDTO) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>(UserDoConvert.dtoToDo(userDTO));
        List<UserDO> userList = userService.list(queryWrapper);
        return R.success(UserDoConvert.listConvert(userList));
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public R info(@RequestParam("id")Long id) {
            UserDO user = userService.getById(id);
        return R.success(UserDoConvert.doToDto(user));
    }

    /**
     * 新增
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody UserDTO userDTO) {
        boolean flag = userService.save(UserDoConvert.dtoToDo(userDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody UserDTO userDTO) {
        boolean flag = userService.updateById(UserDoConvert.dtoToDo(userDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }
}