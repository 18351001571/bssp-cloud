package com.cloud.bssp.generator.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.dto.GenerateRulesDTO;
import com.cloud.bssp.generator.entity.GenerateRulesDO;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * Module: GenerateRulesDoConvert.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-17T10:00:32.925
 * @Descriptions: 
 */
@Component
public class GenerateRulesDoConvert  {

    /**
         * DtoToDo
         *
         * @param generateRulesDTO
         * @return
         */
    public static GenerateRulesDO dtoToDo(GenerateRulesDTO generateRulesDTO) {
        GenerateRulesDO generateRulesDO = new GenerateRulesDO();
        BeanCopierUtil.copy(generateRulesDTO, generateRulesDO);
        return generateRulesDO;
    }

    /**
     * DoToDto
     *
     * @param generateRulesDO
     * @return
     */
    public static GenerateRulesDTO doToDto(GenerateRulesDO generateRulesDO) {
        GenerateRulesDTO generateRulesDTO = new GenerateRulesDTO();
        BeanCopierUtil.copy(generateRulesDO, generateRulesDTO);
        return generateRulesDTO;
    }

    /**
     * Page<DO> to Page<DTO>
     *
     * @param pageDO
     * @return
     */
    public static Page<GenerateRulesDTO> pageConvert(Page<GenerateRulesDO> pageDO) {
        List<GenerateRulesDTO> list = listConvert(pageDO.getRecords());
        Page<GenerateRulesDTO> page = new Page<>(pageDO.getCurrent(), pageDO.getSize(), pageDO.getTotal());
        page.setRecords(list);
        return page;
    }

    /**
     * list<DO> to list<DTO>
     *
     * @param listDO
     * @return
     */
    public static List<GenerateRulesDTO> listConvert(List<GenerateRulesDO> listDO) {
        List<GenerateRulesDTO> list = new ArrayList<>();
        GenerateRulesDTO generateRulesDTO;
        for (GenerateRulesDO generateRulesDO : listDO) {
            generateRulesDTO = new GenerateRulesDTO();
            BeanCopierUtil.copy(generateRulesDO, generateRulesDTO);
            list.add(generateRulesDTO);
        }
        return list;
    }
}