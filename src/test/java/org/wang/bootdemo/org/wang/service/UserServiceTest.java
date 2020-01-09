package org.wang.bootdemo.org.wang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wang.bootdemo.BootdemoApplication;
import org.wang.bootdemo.model.User;
import org.wang.bootdemo.service.UserService;

import java.util.Date;

/**
 * @ClassName UserServiceTest
 * @Description 用户服务类测试
 * @Author wangHao
 * @DATE 2020/1/9 21:14
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootdemoApplication.class)
public class UserServiceTest {
    private UserService userService;

    private User user;

    @Autowired
    public void setUser(User user){
        this.user = user;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Test
    public void execute1() {
        user.setUserName("wanghao");
        user.setMobileNo("13760105120");
        user.setPassword("123456");
        user.setIdno("511303199408021356");
        user.setName("王浩");
        user.setBirthday("1994-08-02");
        user.setCreateTime(new Date());
        user.setSex("1");
        user.setAddress("四川省南充市");
        int row = userService.registerUser(user);
    }

    @Test
    public void execute2(){
        User userInfo = userService.getUserInfoByUserId(1);
    }

    @Test
    public void execute3(){
        user.setUserId(1);
        user.setName("hxm");
        user.setUpdateTime(new Date());
        int row = userService.updateUserInfoByUserId(user);
    }

    @Test
    public void execute4(){
        int row = userService.deleteUserByUserId(1);
    }
}
