package com.cloud.bssp.generator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.convert.TableDoConvert;
import com.cloud.bssp.generator.dto.TableDTO;
import com.cloud.bssp.generator.entity.TableDO;
import com.cloud.bssp.generator.service.GenerateService;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

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
@Api(tags = "代码生成controller")
@RestController
@RequestMapping("/generate")
@AllArgsConstructor
public class GenerateController {

    /**
     * 代码生成service
     */
    private GenerateService generateService;

    /**
     * 分页列表
     * @param tableDTO
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody TableDTO tableDTO) {
        Page<TableDO> page = new Page<>(tableDTO.getPage(), tableDTO.getLimit());
        Page<TableDO> pageList = generateService.page(page, TableDoConvert.dtoToDo(tableDTO));
        return R.success(TableDoConvert.pageConvert(pageList));
    }

    /**
     * 代码生成
     * @param tableDTO
     * @return
     */
    @ApiOperation(value = "代码生成")
    @PostMapping("/generateCode")
    public byte[] generateCode(@RequestBody TableDTO tableDTO) {
        ByteArrayOutputStream outputStream = generateService.generateCode(TableDoConvert.dtoToDo(tableDTO));
        return outputStream.toByteArray();
    }

    /**
     * 代码预览
     * @param tableDTO
     * @return
     */
    @ApiOperation(value = "代码预览")
    @PostMapping("/previewCode")
    public R previewCode(@RequestBody TableDTO tableDTO) {
        Map<String,Map<String,Object>> map = generateService.previewCode(TableDoConvert.dtoToDo(tableDTO));
        return R.success(map);
    }
}
