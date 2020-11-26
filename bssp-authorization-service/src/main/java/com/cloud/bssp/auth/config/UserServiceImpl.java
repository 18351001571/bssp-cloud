package com.cloud.bssp.auth.config;

import com.alibaba.fastjson.JSONObject;
import com.cloud.bssp.constants.SystemConstant;
import com.cloud.bssp.user.dto.UserDTO;
import com.cloud.bssp.util.R;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserClient userClient;

    private RoleClient roleClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户账号获取用户信息
        R r = userClient.getByUsername(username);
        if (r.getCode() != SystemConstant.ZERO) {
            return null;
        }
        UserDTO user = JSONObject.parseObject(JSONObject.toJSONString(r.getData()), UserDTO.class);
        //获取用户角色
        R byUserId = roleClient.getByUserId(user.getId());
        RoleDTO role = JSONObject.parseObject(JSONObject.toJSONString(byUserId.getData()), RoleDTO.class);
        List<RoleDTO> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        return user;
    }
}