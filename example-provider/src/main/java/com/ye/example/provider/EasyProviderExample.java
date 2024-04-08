package com.ye.example.provider;

import com.ye.example.common.service.UserService;
import com.ye.yerpc.registry.LocalRegistry;
import com.ye.yerpc.server.HttpServer;
import com.ye.yerpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        //启动web服务
        HttpServer httpServer=new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
