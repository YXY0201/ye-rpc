package com.ye.example.consumer;

import com.ye.example.common.model.User;
import com.ye.example.common.service.UserService;
import com.ye.yerpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {

       //动态代理
        UserService userService= ServiceProxyFactory.getProxy(UserService.class);
        User user=new User();
        user.setName("yexianya");
        //调用
        User newUser=userService.getUser(user);
        if(newUser!=null){
            System.out.println(newUser.getName());
        }else {
            System.out.println("user==null");
        }

    }
}