package com.bbd.wtyh.core.utils.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.io.Serializable;

/**
 * 扩展操作工具类
 *
 * @author Created by LiYao on 2017-09-11 15:15.
 */
@SuppressWarnings("unused")
class ExtensionOperationUtil extends SortedSetOperationUtil {

    /**
     * 将 obj 转为 JSON 后存入 redis
     * 
     * @param key
     * @param obj
     */
    public static void setObjectJson(String key, Object obj) {
        set(key, JSON.toJSONString(obj));
    }

    /**
     * 将存入Redis的json 字符串还原为Obj
     * 
     * @param key
     * @param clazz
     * @return
     */
    public static <T> T getObjectJson(String key, Class<T> clazz) {
        return JSON.parseObject(get(key), clazz);
    }

    /**
     * 存入一个对象，需要实现 Serializable 接口。
     * 
     * @param key
     * @param obj
     */
    public static void setObject(String key, Serializable obj) {
        set(key.getBytes(), SerializationUtils.serialize(obj));
    }

    /**
     * 获取 setObject 存入的对象
     * 
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObject(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return SerializationUtils.deserialize(jedis.get(key.getBytes()));
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }
}
