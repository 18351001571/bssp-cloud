package com.cloud.bssp.auth.client;

import com.cloud.bssp.auth.dto.UserDTO;
import com.cloud.bssp.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
@FeignClient(name = "bssp-user-service", path = "/user", contextId = "user")
public interface UserClient {

    /**
     * 分页列表
     * @param params
     * @return
     */
    @PostMapping("/pageList")
    R pageList(@RequestBody Map<String, Object> params);

    /**
     * list列表
     * @param userDTO
     * @return
     */
    @PostMapping("/list")
    R list(@RequestBody UserDTO userDTO);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @GetMapping("/info/getById")
    R info(@RequestParam("id") Long id);

    /**
     * 新增
     * @param userDTO
     * @return
     */
    @PostMapping("/save")
    R save(@RequestBody UserDTO userDTO);

    /**
     * 更新
     * @param userDTO
     * @return
     */
    @PostMapping("/update")
    R update(@RequestBody UserDTO userDTO);
}