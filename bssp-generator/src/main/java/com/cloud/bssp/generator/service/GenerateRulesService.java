package com.cloud.bssp.generator.service;

import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.config.mybatisplus.IDataService;

/**
 * Module: GenerateRulesService.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-17T10:00:32.925
 * @Descriptions:
 */
public interface GenerateRulesService extends IDataService<GenerateRulesDO> {

    /**
     * Description: 获取规则
     * Created date: 2020/7/20
     * @return com.cloud.bssp.generator.entity.GenerateRulesDO
     * @author weirx
     */
    GenerateRulesDO getRules();

    /**
     * Description: 保存规则
     * Created date: 2020/7/20
     * @param generateRulesDO
     * @return boolean
     * @author weirx
     */
    boolean saveRules(GenerateRulesDO generateRulesDO);
}