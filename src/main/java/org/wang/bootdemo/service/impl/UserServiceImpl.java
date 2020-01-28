package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.mapper.UserMapper;
import org.wang.bootdemo.model.User;
import org.wang.bootdemo.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description 用户实例类
 * @Author wangHao
 * @DATE 2020/1/5 22:10
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public int registerUser(User user) {
        User userInfo = userMapper.getUserInfoByUserName(user.getUserName());
        if (userInfo != null){
            return 0;
        }else {
            return userMapper.insertSelective(user);
        }
    }

    @Override
    public User getUserInfoByUserId(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfoByUserId(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserByUserId(int userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User getUserInfoByUserNameByPassword(String username, String password) {
        return userMapper.getUserInfoByUserNameByPassword(username, password);
    }
}
