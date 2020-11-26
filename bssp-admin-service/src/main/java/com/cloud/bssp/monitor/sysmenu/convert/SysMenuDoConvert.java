package com.cloud.bssp.monitor.sysmenu.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.monitor.sysmenu.dto.SysMenuDTO;
import com.cloud.bssp.monitor.sysmenu.entity.SysMenuDO;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Module: SysMenuDoConvert.java
 *
 * @author weirx
 * @since JDK 1.8
 * @version 1.0
 * @date 2020-07-13
 * @Descriptions: 菜单
 */
@Component
public class SysMenuDoConvert {

    /**
     * DtoToDo
     *
     * @param sysMenuDTO
     * @return
     */
    public static SysMenuDO dtoToDo(SysMenuDTO sysMenuDTO) {
        SysMenuDO sysMenuDO = new SysMenuDO();
        BeanCopierUtil.copy(sysMenuDTO, sysMenuDO);
        return sysMenuDO;
    }

    /**
     * DoToDto
     *
     * @param sysMenuDO
     * @return
     */
    public static SysMenuDTO doToDto(SysMenuDO sysMenuDO) {
        SysMenuDTO sysMenuDTO = new SysMenuDTO();
        BeanCopierUtil.copy(sysMenuDO, sysMenuDTO);
        return sysMenuDTO;
    }

    /**
     * Page<DO> to Page<DTO>
     *
     * @param pageDO
     * @return
     */
    public static Page<SysMenuDTO> pageConvert(Page<SysMenuDO> pageDO) {
        List<SysMenuDTO> list = listConvert(pageDO.getRecords());
        Page<SysMenuDTO> page = new Page<>(pageDO.getCurrent(), pageDO.getSize(), pageDO.getTotal());
        page.setRecords(list);
        return page;
    }

    /**
     * list<DO> to list<DTO>
     *
     * @param listDO
     * @return
     */
    public static List<SysMenuDTO> listConvert(List<SysMenuDO> listDO) {
        List<SysMenuDTO> list = new ArrayList<>();
        SysMenuDTO sysMenuDTO;
        for (SysMenuDO sysMenuDO : listDO) {
            sysMenuDTO = new SysMenuDTO();
            BeanCopierUtil.copy(sysMenuDO, sysMenuDTO);
            list.add(sysMenuDTO);
        }
        return list;
    }
}
