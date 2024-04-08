package com.ye.example.common.service;

import com.ye.example.common.model.User;

/**
 * 用户服务
 */
public interface UserService {

    User getUser(User user);

    default short getNumber() {
        return 1;
    }

}
