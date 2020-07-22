package com.cloud.bssp.generator.service.impl;

import com.cloud.bssp.constants.SystemConstant;
import com.cloud.bssp.generator.dao.GenerateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.generator.service.GenerateRulesService;
import com.cloud.bssp.generator.dao.GenerateRulesMapper;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Module: GenerateRulesServiceImpl.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-17T10:14:54.036
 * @Descriptions:
 */
@Service
@AllArgsConstructor
public class GenerateRulesServiceImpl extends ServiceImpl<GenerateRulesMapper, GenerateRulesDO> implements GenerateRulesService {

    /**
     * 代码生成mapper
     */
    private GenerateRulesMapper generateRulesMapper;

    @Override
    public GenerateRulesDO getRules() {
        List<GenerateRulesDO> generateRulesDOS = generateRulesMapper.selectList(null);
        if (CollectionUtils.isEmpty(generateRulesDOS)) {
            return new GenerateRulesDO();
        }
        return generateRulesDOS.get(0);
    }

    @Override
    public boolean saveRules(GenerateRulesDO generateRulesDO) {
        int count;
        List<GenerateRulesDO> generateRulesDOS = generateRulesMapper.selectList(null);
        if (CollectionUtils.isEmpty(generateRulesDOS)) {
            generateRulesDO.setCreateTime(LocalDateTime.now());
            count = generateRulesMapper.insert(generateRulesDO);
        } else {
            generateRulesDO.setUpdateTime(LocalDateTime.now());
            count = generateRulesMapper.updateById(generateRulesDO);
        }
        if (count > SystemConstant.ZERO) {
            return true;
        } else {
            return false;
        }
    }
}