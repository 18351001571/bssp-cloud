package com.cloud.bssp.user.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.user.dto.RoleDTO;
import com.cloud.bssp.user.entity.RoleDO;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Create Date: 2020-07-23T14:46:53.286
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Component
public class RoleDoConvert {

    /**
     * DtoToDo
     *
     * @param roleDTO
     * @return
     */
    public static RoleDO dtoToDo(RoleDTO roleDTO) {
        RoleDO roleDO = new RoleDO();
        BeanCopierUtil.copy(roleDTO, roleDO);
        return roleDO;
    }

    /**
     * DoToDto
     *
     * @param roleDO
     * @return
     */
    public static RoleDTO doToDto(RoleDO roleDO) {
        RoleDTO roleDTO = new RoleDTO();
        BeanCopierUtil.copy(roleDO, roleDTO);
        return roleDTO;
    }

    /**
     * Page<DO> to Page<DTO>
     *
     * @param pageDO
     * @return
     */
    public static Page<RoleDTO> pageConvert(Page<RoleDO> pageDO) {
        List<RoleDTO> list = listConvert(pageDO.getRecords());
        Page<RoleDTO> page = new Page<>(pageDO.getCurrent(), pageDO.getSize(), pageDO.getTotal());
        page.setRecords(list);
        return page;
    }

    /**
     * list<DO> to list<DTO>
     *
     * @param listDO
     * @return
     */
    public static List<RoleDTO> listConvert(List<RoleDO> listDO) {
        List<RoleDTO> list = new ArrayList<>();
        RoleDTO roleDTO;
        for (RoleDO roleDO : listDO) {
            roleDTO = new RoleDTO();
            BeanCopierUtil.copy(roleDO, roleDTO);
            list.add(roleDTO);
        }
        return list;
    }
}
