package com.cloud.bssp.user.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.bssp.user.dto.UserRoleDTO;
import com.cloud.bssp.user.entity.UserRoleDO;
import com.cloud.bssp.util.BeanCopierUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 用户角色关系表
 * Create Date: 2020-07-23T14:46:56.062
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Component
public class UserRoleDoConvert {

    /**
     * DtoToDo
     *
     * @param userRoleDTO
     * @return
     */
    public static UserRoleDO dtoToDo(UserRoleDTO userRoleDTO) {
        UserRoleDO userRoleDO = new UserRoleDO();
        BeanCopierUtil.copy(userRoleDTO, userRoleDO);
        return userRoleDO;
    }

    /**
     * DoToDto
     *
     * @param userRoleDO
     * @return
     */
    public static UserRoleDTO doToDto(UserRoleDO userRoleDO) {
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        BeanCopierUtil.copy(userRoleDO, userRoleDTO);
        return userRoleDTO;
    }

    /**
     * Page<DO> to Page<DTO>
     *
     * @param pageDO
     * @return
     */
    public static Page<UserRoleDTO> pageConvert(Page<UserRoleDO> pageDO) {
        List<UserRoleDTO> list = listConvert(pageDO.getRecords());
        Page<UserRoleDTO> page = new Page<>(pageDO.getCurrent(), pageDO.getSize(), pageDO.getTotal());
        page.setRecords(list);
        return page;
    }

    /**
     * list<DO> to list<DTO>
     *
     * @param listDO
     * @return
     */
    public static List<UserRoleDTO> listConvert(List<UserRoleDO> listDO) {
        List<UserRoleDTO> list = new ArrayList<>();
        UserRoleDTO userRoleDTO;
        for (UserRoleDO userRoleDO : listDO) {
            userRoleDTO = new UserRoleDTO();
            BeanCopierUtil.copy(userRoleDO, userRoleDTO);
            list.add(userRoleDTO);
        }
        return list;
    }
}
