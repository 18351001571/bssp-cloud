package com.cloud.bssp.generator.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.dto.TableDTO;
import com.cloud.bssp.generator.entity.TableDO;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Module: TableDoConvert.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-13
 * @Descriptions: 菜单
 */
@Component
public class TableDoConvert {

    /**
     * DtoToDo
     *
     * @param tableDTO
     * @return
     */
    public static TableDO dtoToDo(TableDTO tableDTO) {
        TableDO tableDO = new TableDO();
        BeanCopierUtil.copy(tableDTO, tableDO);
        return tableDO;
    }

    /**
     * DoToDto
     *
     * @param tableDO
     * @return
     */
    public static TableDTO doToDto(TableDO tableDO) {
        TableDTO tableDTO = new TableDTO();
        BeanCopierUtil.copy(tableDO, tableDTO);
        return tableDTO;
    }

    /**
     * Page<DO> to Page<DTO>
     *
     * @param pageDO
     * @return
     */
    public static Page<TableDTO> pageConvert(Page<TableDO> pageDO) {
        List<TableDTO> list = listConvert(pageDO.getRecords());
        Page<TableDTO> page = new Page<>(pageDO.getCurrent(), pageDO.getSize(), pageDO.getTotal());
        page.setRecords(list);
        return page;
    }

    /**
     * list<DO> to list<DTO>
     *
     * @param listDO
     * @return
     */
    public static List<TableDTO> listConvert(List<TableDO> listDO) {
        List<TableDTO> list = new ArrayList<>();
        TableDTO tableDTO;
        for (TableDO tableDO : listDO) {
            tableDTO = new TableDTO();
            BeanCopierUtil.copy(tableDO, tableDTO);
            list.add(tableDTO);
        }
        return list;
    }
}