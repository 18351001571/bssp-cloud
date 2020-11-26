package com.cloud.bssp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.bssp.user.entity.RoleDO;
import com.cloud.bssp.user.entity.UserRoleDO;
import com.cloud.bssp.user.mapper.RoleMapper;
import com.cloud.bssp.user.mapper.UserRoleMapper;
import com.cloud.bssp.user.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
@Service
@AllArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements RoleService {

    /**
     * 用户角色关联mapper
     */
    private UserRoleMapper userRoleMapper;

    /**
     * 角色mapper
     */
    private RoleMapper roleMapper;

    @Override
    public RoleDO getByUserId(Long userId) {
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setUserId(userId);
        UserRoleDO userRole = userRoleMapper.selectOne(new QueryWrapper<>(userRoleDO));
        if (ObjectUtils.isEmpty(userRole.getRoleId())) {
            return null;
        }
        return roleMapper.selectById(userRole.getRoleId());
    }
}