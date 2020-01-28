package org.wang.bootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wang.bootdemo.model.User;
import org.wang.bootdemo.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class ProductController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public User getUserByUserNameAndPassword(@RequestParam("username")String username, @RequestParam("password")
                                               String password){
        User userInfo = userService.getUserInfoByUserNameByPassword(username, password);
        if (userInfo != null){
            return userInfo;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/register")
    public int setUser(HttpServletRequest httpServletRequest){
        User userInfo = new User();
        userInfo.setUserName(httpServletRequest.getParameter("username"));
        return userService.registerUser(userInfo);
    }
}
