package com.ye.example.provider;

import com.ye.example.common.service.UserService;
import com.ye.yerpc.RpcApplication;
import com.ye.yerpc.bootstrap.ProviderBootstrap;
import com.ye.yerpc.model.ServiceRegisterInfo;
import com.ye.yerpc.registry.LocalRegistry;
import com.ye.yerpc.server.HttpServer;
import com.ye.yerpc.server.VertxHttpServer;

import java.util.ArrayList;
import java.util.List;

/**
 * 简易服务提供者示例
 */
public class ProviderExample {

    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo<UserService> serviceRegisterInfo = new ServiceRegisterInfo<>(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}
