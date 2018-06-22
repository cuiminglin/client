package com.cui.service;

import com.cui.entity.User;

/**
 * Created by cuiminglin on 2018/4/27.
 */
public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);
}
