package com.cloud.bssp.generator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.convert.GenerateRulesDoConvert;
import com.cloud.bssp.generator.convert.TableDoConvert;
import com.cloud.bssp.generator.dto.GenerateRulesDTO;
import com.cloud.bssp.generator.dto.TableDTO;
import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.generator.entity.TableDO;
import com.cloud.bssp.generator.service.GenerateRulesService;
import com.cloud.bssp.generator.service.GenerateService;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
     * 生成规则service
     */
    private GenerateRulesService generateRulesService;

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
        if (ObjectUtils.isEmpty(outputStream)) {
            return null;
        }
        return outputStream.toByteArray();
    }

    /**
     * 代码预览
     * @param tableName
     * @return
     */
    @ApiOperation(value = "代码预览")
    @GetMapping("/previewCode")
    public R previewCode(@RequestParam String tableName) {
        List<Map<String, String>> list = generateService.previewCode(tableName);
        if (ObjectUtils.isEmpty(list)) {
            return R.failed("请先设置生成规则");
        }
        return R.success(list);
    }

    /**
     * 保存规则
     * @param generateRulesDTO
     * @return
     */
    @ApiOperation(value = "保存规则")
    @PostMapping("/saveRules")
    public R saveRules(@RequestBody GenerateRulesDTO generateRulesDTO) {
        boolean flag = generateRulesService.saveRules(GenerateRulesDoConvert.dtoToDo(generateRulesDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * Description: 获取规则
     * Created date: 2020/7/20
     * @return com.cloud.bssp.util.R
     * @author weirx
     */
    @ApiOperation(value = "获取规则")
    @GetMapping("/getRules")
    public R info() {
        GenerateRulesDO generateRules = generateRulesService.getRules();
        return R.success(GenerateRulesDoConvert.doToDto(generateRules));
    }
}
