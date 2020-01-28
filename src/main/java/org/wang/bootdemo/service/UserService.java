package org.wang.bootdemo.service;

import org.springframework.stereotype.Service;
import org.wang.bootdemo.model.User;

/**
 * @ClassName UserService
 * @Description 用户接口类
 * @Author wangHao
 * @DATE 2020/1/5 22:10
 * @Version 1.0
 */
public interface UserService {

    /**
     * @description 用户注册
     * @author wangHao
     * @date 2020/1/9 20:52
     * @param [user]
     * @return int
     */
    int registerUser(User user);

    /**
     * @description 根据用户编号查询用户信息
     * @author wangHao
     * @date 2020/1/9 20:55
     * @param [userId]
     * @return org.wang.bootdemo.model.User
     */
    User getUserInfoByUserId(int userId);

    /**
     * @description 根据用户编号更新用户信息
     * @author wangHao
     * @date 2020/1/9 20:57
     * @param [userId]
     * @return int
     */
    int updateUserInfoByUserId(User user);

    /**
     * @description 根据用户编号删除用户信息
     * @author wangHao
     * @date 2020/1/9 20:58
     * @param [userId]
     * @return int
     */
    int deleteUserByUserId(int userId);

    /**
     * 根据用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    User getUserInfoByUserNameByPassword(String username, String password);
}
