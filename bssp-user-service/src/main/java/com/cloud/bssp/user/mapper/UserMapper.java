package com.cloud.bssp.user.mapper;

import com.cloud.bssp.user.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: 用户表
 * Create Date: 2020-07-22T16:35:33.892
 * Modified By：<br>
 * Modified Date：<br>
 * Why & What is modified：<br>
 *
 * @author weirx
 * @version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}