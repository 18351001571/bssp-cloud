package com.cloud.bssp.auth.config;

import com.cloud.bssp.util.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
@FeignClient(name = "bssp-user-service", path = "/role", contextId = "role")
public interface RoleClient {

    /**
     * 根据用户id查询角色list
     * @param userId
     * @return
     */
    @GetMapping("/getByUserId")
    R getByUserId(@RequestParam("userId") Long userId);
}
