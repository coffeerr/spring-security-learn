package com.desmond.springsecuritylearn.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.desmond.springsecuritylearn.entity.User;
import com.desmond.springsecuritylearn.service.IUserService;
import com.desmond.springsecuritylearn.service.PearlUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Desmond
 * @time: 2023/7/1 10:39 AM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        1、数据库查询用户
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, username));
        if (ObjectUtil.isNull(user)) {
            log.error("return nothing username:" + username);
            throw new UsernameNotFoundException(String.format("Username {} not found", username));
        } else {
//        2、设计权限集合
            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
//        3、返回UserDetails用户
            return new PearlUserDetails(user.getPassword(), user.getUserName(), user.getPhone()
                    , authorityList, true, true, true, true);
        }
    }
}
