package com.desmond.springsecuritylearn.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.desmond.springsecuritylearn.entity.User;
import com.desmond.springsecuritylearn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Desmond
 * @time: 2023/7/1 12:34 AM
 */

@RestController
public class TestController {
    @Autowired
    IUserService userService;

    @GetMapping("/test")
    public Object test() {
        return "Hello Security";
    }

    @GetMapping("/test2")
    public Object test2() {
        return userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));

    }
}


