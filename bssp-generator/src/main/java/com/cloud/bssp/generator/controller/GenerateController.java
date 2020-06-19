package com.cloud.bssp.generator.controller;

import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 代码生成控制器
 * Create Date: 2020/6/19
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Api(tags = "代码生成")
@RestController
@RequestMapping("/admin/generate")
public class GenerateController {

    @ApiOperation(value = "sayHello")
    @RequestMapping("/list")
    public R queryTableList(@RequestParam String id) {
        return R.success();
    }
}
