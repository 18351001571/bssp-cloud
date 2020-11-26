package com.cloud.bssp.user.mapper;

import com.cloud.bssp.user.entity.UserRoleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {
}