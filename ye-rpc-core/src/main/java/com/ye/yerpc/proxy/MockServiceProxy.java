package com.ye.yerpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * mock服务代理（jdk动态代理）
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler {

    /**
     * 调用代理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据方法的返回值类型，生成特定的默认值对象
        Class<?> methodReturnType=method.getReturnType();
        log.info("mock invoke {}",method.getName());
        return getDefaultObject(methodReturnType);
    }

    /**
     * 生成指定类型的默认值对象
     */
    public Object getDefaultObject(Class<?> type){
        if(type.isPrimitive()){
            if(type==boolean.class){
                return  false;
            }else if(type==short.class){
                return (short)0;
            }else if(type==int.class){
                return 0;
            }else if(type==long.class){
                return 0L;
            }
        }
        return null;
    }

}
