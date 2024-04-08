package com.ye.yerpc;

import com.ye.yerpc.config.RegistryConfig;
import com.ye.yerpc.config.RpcConfig;
import com.ye.yerpc.constant.RpcConstant;
import com.ye.yerpc.registry.Registry;
import com.ye.yerpc.registry.RegistryFactory;
import com.ye.yerpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * RPC框架应用
 * 相当于holder，存放了项目全局用到的变量。双检锁单例模式实现
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     */
    public static void init(RpcConfig newRpcConfig){
        rpcConfig=newRpcConfig;
        log.info("rpc init,config = {}",newRpcConfig.toString());
        //注册中心初始化
        RegistryConfig registryConfig=rpcConfig.getRegistryConfig();
        Registry registry= RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init,config={}",registryConfig);
        //创建并注册Shutdown Hook，JVM退出时执行操作
        Runtime.getRuntime().addShutdownHook(new Thread(registry::destroy));
    }

    /**
     * 初始化
     */
    public static void init(){
        RpcConfig newRpcConfig;
        try{
            newRpcConfig= ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        }catch(Exception e){
            newRpcConfig=new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     * 获取配置
     */
    public static RpcConfig getRpcConfig(){
        if(rpcConfig==null){
            synchronized (RpcApplication.class){
                if(rpcConfig==null){
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
