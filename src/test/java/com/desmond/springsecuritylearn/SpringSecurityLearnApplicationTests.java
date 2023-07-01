package com.desmond.springsecuritylearn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.desmond.springsecuritylearn.entity.User;
import com.desmond.springsecuritylearn.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest(classes = SpringSecurityLearnApplication.class)
class SpringSecurityLearnApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserServiceImpl userService;

    @Test
    @DisplayName("测试数据库访问是否成功过")
    public void userQueryTest() {
        User admin = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));
        Assertions.assertEquals(admin.getLoginName(), "admin");
    }

    @Test
    @DisplayName("测试插入数据是否成功（使用Security编码）")
    void insertUserTest() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setLoginName("管理员");
        user.setPhone("12312312312");
        boolean save = userService.save(user);
        Assertions.assertTrue(save);
    }

}
