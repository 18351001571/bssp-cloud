package com.cloud.bssp.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.bssp.user.entity.UserDO;
import com.cloud.bssp.user.service.UserService;
import com.cloud.bssp.user.mapper.UserMapper;

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
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}