package com.ye.yerpc.config;

import com.ye.yerpc.fault.retry.RetryStrategyKeys;
import com.ye.yerpc.fault.tolerant.TolerantStrategyKeys;
import com.ye.yerpc.loadbalancer.LoadBalancerKeys;
import com.ye.yerpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * RPC框架全局配置
 */
@Data
public class RpcConfig {

    /**
     * 基本信息
     */
    private String name="ye-rpc";

    private String version="1.0";

    private String serverHost="localhost";

    private Integer serverPort=8080;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 负载均衡器
     */
    private String loadBalancer= LoadBalancerKeys.ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy= RetryStrategyKeys.NO;

    /**
     * 容错策略
     */
    private String tolerantStrategy= TolerantStrategyKeys.FAIL_FAST;

    /**
     *模拟调用
     */
    private boolean mock=false;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig=new RegistryConfig();


}
