package com.ye.examplespringbootconsumer;

import com.ye.example.common.model.User;
import com.ye.example.common.service.UserService;
import com.ye.yerpcspringbootstarter.annotation.RpcReference;
import org.springframework.stereotype.Service;

/**
 * 示例服务实现类
 */
@Service
public class ExampleServiceImpl {

    /**
     * 使用 Rpc 框架注入
     */
    @RpcReference
    private UserService userService;

    /**
     * 测试方法
     */
    public void test() {
        User user = new User();
        user.setName("yexianya");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}
