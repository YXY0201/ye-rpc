package com.ye.yerpc.serializer;

import java.io.IOException;

/**
 * 序列化接口
 */
public interface Serializer {

    /**
     * 序列化
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}
