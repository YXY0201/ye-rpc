package com.ye.examplespringbootprovider;

import com.ye.example.common.model.User;
import com.ye.example.common.service.UserService;
import com.ye.yerpcspringbootstarter.annotation.RpcService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 */
@Service
@RpcService
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
