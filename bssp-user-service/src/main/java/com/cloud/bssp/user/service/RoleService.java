package com.cloud.bssp.user.service;

import com.cloud.bssp.user.dto.RoleDTO;
import com.cloud.bssp.user.entity.RoleDO;
import com.cloud.bssp.config.mybatisplus.IDataService;

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
public interface RoleService extends IDataService<RoleDO> {

    /**
     * Description: 根据userId获取角色list
     * Created date: 2020/7/23
     * @param userId
     * @return java.util.List<com.cloud.bssp.user.dto.RoleDTO>
     * @author weirx
     */
    RoleDO getByUserId(Long userId);
}