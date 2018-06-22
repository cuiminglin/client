package com.cui.service;

import com.cui.dao.UserDao;
import com.cui.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cuiminglin on 2018/4/27.
 */
@Service("userService")
public class UserServiceImple implements  UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public boolean addUser(User record) {
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
