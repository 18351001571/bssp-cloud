package com.cloud.bssp.generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.generator.dto.GenerateRulesDTO;
import com.cloud.bssp.generator.service.GenerateRulesService;
import com.cloud.bssp.generator.convert.GenerateRulesDoConvert;
import com.cloud.bssp.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * GenerateRules Controller控制器
 * </p>
 *
 * @author weirx
 * @since 2020-07-17T10:10:26.179
 */
@Api(tags = "")
@RestController
@RequestMapping("/generaterules")
@AllArgsConstructor
public class GenerateRulesController {

    /**
     * GenerateRulesService
     */
    private GenerateRulesService generateRulesService;

    /**
     * 分页列表
     * @param generateRulesDTO
     * @return
     */
    @ApiOperation(value = "分页列表")
    @PostMapping("/pageList")
    public R pageList(@RequestBody GenerateRulesDTO generateRulesDTO) {
        QueryWrapper<GenerateRulesDO> queryWrapper = new QueryWrapper<>(GenerateRulesDoConvert.dtoToDo(generateRulesDTO));
        Page<GenerateRulesDO> page = new Page<>(generateRulesDTO.getPage(), generateRulesDTO.getLimit());
        Page<GenerateRulesDO> pageList = generateRulesService.page(page, queryWrapper);
        return R.success(GenerateRulesDoConvert.pageConvert(pageList));
    }

    /**
     * list列表
     * @param generateRulesDTO
     * @return
     */
    @ApiOperation(value = "list列表")
    @PostMapping("/list")public R list(@RequestBody GenerateRulesDTO generateRulesDTO) {
        QueryWrapper<GenerateRulesDO> queryWrapper = new QueryWrapper<>(GenerateRulesDoConvert.dtoToDo(generateRulesDTO));
        List<GenerateRulesDO> generateRulesList = generateRulesService.list(queryWrapper);
        return R.success(GenerateRulesDoConvert.listConvert(generateRulesList));
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/info/getById")
    public R info(@RequestParam("id") Long id) {
            GenerateRulesDO generateRules = generateRulesService.getById(id);
        return R.success(GenerateRulesDoConvert.doToDto(generateRules));
    }

    /**
     * 新增
     * @param generateRulesDTO
     * @return
     */
    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public R save(@RequestBody GenerateRulesDTO generateRulesDTO) {
        boolean flag = generateRulesService.save(GenerateRulesDoConvert.dtoToDo(generateRulesDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 更新
     * @param generateRulesDTO
     * @return
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody GenerateRulesDTO generateRulesDTO) {
        boolean flag =  generateRulesService.updateById(GenerateRulesDoConvert.dtoToDo(generateRulesDTO));
        if (flag) {
            return R.success();
        }
        return R.failed();
    }
}