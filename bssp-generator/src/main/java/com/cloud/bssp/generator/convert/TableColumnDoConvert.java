package com.cloud.bssp.generator.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.generator.dto.TableColumnDTO;
import com.cloud.bssp.generator.entity.TableColumnDO;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Module: TableColumnColumnDoConvert.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-13
 * @Descriptions: 菜单
 */
@Component
public class TableColumnDoConvert {

    /**
     * DtoToDo
     *
     * @param tableColumnDTO
     * @return
     */
    public static TableColumnDO dtoToDo(TableColumnDTO tableColumnDTO) {
        TableColumnDO tableColumnDO = new TableColumnDO();
        BeanCopierUtil.copy(tableColumnDTO, tableColumnDO);
        return tableColumnDO;
    }

    /**
     * DoToDto
     *
     * @param tableColumnDO
     * @return
     */
    public static TableColumnDTO doToDto(TableColumnDO tableColumnDO) {
        TableColumnDTO tableColumnDTO = new TableColumnDTO();
        BeanCopierUtil.copy(tableColumnDO, tableColumnDTO);
        return tableColumnDTO;
    }

    /**
     * Page<DO> to Page<DTO>
     *
     * @param pageDO
     * @return
     */
    public static Page<TableColumnDTO> pageConvert(Page<TableColumnDO> pageDO) {
        List<TableColumnDTO> list = listConvert(pageDO.getRecords());
        Page<TableColumnDTO> page = new Page<>(pageDO.getCurrent(), pageDO.getSize(), pageDO.getTotal());
        page.setRecords(list);
        return page;
    }

    /**
     * list<DO> to list<DTO>
     *
     * @param listDO
     * @return
     */
    public static List<TableColumnDTO> listConvert(List<TableColumnDO> listDO) {
        List<TableColumnDTO> list = new ArrayList<>();
        TableColumnDTO tableColumnDTO;
        for (TableColumnDO tableColumnDO : listDO) {
            tableColumnDTO = new TableColumnDTO();
            BeanCopierUtil.copy(tableColumnDO, tableColumnDTO);
            list.add(tableColumnDTO);
        }
        return list;
    }
}