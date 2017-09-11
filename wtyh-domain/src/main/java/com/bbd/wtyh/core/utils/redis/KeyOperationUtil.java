package com.bbd.wtyh.core.utils.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * key 操作工具类
 *
 * @author Created by LiYao on 2017-09-11 15:07.
 */
@SuppressWarnings("unused")
class KeyOperationUtil extends RedisBaseUtil {

    /**
     * 该命令用于在 key 存在时删除 key。
     *
     * @param key
     * @return 被删除 key 的数量。
     */
    public static long del(String key) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.del(key);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于检查给定 key 是否存在。
     *
     * @param key
     * @return 若 key 存在返回 true ，否则返回 false 。
     */
    public static boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            pool.returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于设置 key 的过期时间。key 过期后将不再可用。
     *
     * @param key
     * @param seconds 过期时间，单位秒
     *
     * @return 设置成功返回 true 。当 key 不存在或者不能为 key 设置过期时间时返回 false 。
     */
    public static boolean expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.expire(key, seconds) == 1;
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于查找所有符合给定模式 pattern 的 key 。
     *
     * @param pattern
     * @return 符合给定模式的 key 列表
     */
    public static Set<String> keys(String pattern) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.keys(pattern);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 以秒为单位返回 key 的剩余过期时间。
     *
     * @param key
     * @return 当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key 的剩余生存时间。
     */
    public static Long ttl(String key) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.ttl(key);
        } catch (Exception e) {
            pool.returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于移除给定 key 的过期时间，使得 key 永不过期。
     *
     * @param key
     * @return 当过期时间移除成功时，返回 true 。 如果 key 不存在或 key 没有设置过期时间，返回 false 。
     */
    public static boolean persist(String key) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.persist(key) == 1;
        } catch (Exception e) {
            pool.returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }
}
