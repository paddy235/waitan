package com.bbd.wtyh.core.utils.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 列表操作工具类
 *
 * @author Created by LiYao on 2017-09-11 15:13.
 */
@SuppressWarnings("unused")
class ListOperationUtil extends HashOperationUtil {

    public static long lpush(String key, String... values) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.lpush(key, values);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    public static long rpush(String key, String... values) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.rpush(key, values);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    public static List<String> lrange(String key, int start, int count) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.lrange(key, start, count);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

}
