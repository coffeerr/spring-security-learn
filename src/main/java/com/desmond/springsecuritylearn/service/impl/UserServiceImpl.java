package com.desmond.springsecuritylearn.service.impl;


import com.desmond.springsecuritylearn.entity.User;
import com.desmond.springsecuritylearn.mapper.UserMapper;
import com.desmond.springsecuritylearn.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author desmond
 * @since 2023-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
