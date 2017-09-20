package com.bbd.wtyh.core.utils.redis;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Hash 操作工具类
 *
 * @author Created by LiYao on 2017-09-11 15:11.
 */
@SuppressWarnings("unused")
class HashOperationUtil extends StringOperationUtil {

    /**
     * 用于为哈希表中的字段赋值 。 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。 如果字段已经存在于哈希表中，旧值将被覆盖。
     * 
     * @param redisKey
     * @param field
     * @param value
     */
    public static void hset(String redisKey, String field, String value) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            jedis.hset(redisKey, field, value);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于同时将多个 field-value (字段-值)对设置到哈希表中。
     * 
     * @param key
     * @param hash
     */
    public static void hmset(String key, Map<String, String> hash) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            jedis.hmset(key, hash);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于返回哈希表中指定字段的值。
     *
     * @param key
     * @param field
     * @return 返回给定字段的值。如果给定的字段或 key 不存在时，返回 null 。
     */
    public static String hget(String key, String field) {
        Jedis jedis = null;
        String value;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.hget(key, field);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于返回哈希表中，一个或多个给定字段的值。
     * 
     * @param key
     * @param fields
     * @return
     */
    public static List<String> hmget(String key, String... fields) {
        if (arrayIsEmpty(fields)) {
            return new ArrayList<>(0);
        }
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.hmget(key, fields);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于返回哈希表中，所有的字段和值。
     * 
     * @param key
     * @return 哈希表的字段及字段值。
     */
    public static Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        Map<String, String> map;
        boolean isBroken = false;
        try {
            jedis = getResource();
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
        if (map == null) {
            return new HashMap<>();
        }
        return map;
    }

    /**
     * 用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略。
     * 
     * @param key
     * @param field
     */
    public static void hdel(String key, String... fields) {
        if (arrayIsEmpty(fields)) {
            return;
        }
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            jedis.hdel(key, fields);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于查看哈希表的指定字段是否存在。
     *
     * @param key
     * @param field
     * @return 如果哈希表含有给定字段，返回 true 。 如果哈希表不含有给定字段，或 key 不存在，返回 false 。
     */
    public static boolean hexist(String key, String field) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.hexists(key, field);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于获取哈希表中的所有域（field）。
     * 
     * @param redisKey
     * @return 包含哈希表中所有域（field）列表。 当 key 不存在时，返回一个空列表。
     */
    public Set<String> hkeys(String key) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.hkeys(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }

    /**
     * 用于获取哈希表中字段的数量。
     *
     * @param key
     * @return 哈希表中字段的数量。 当 key 不存在时，返回 0 。
     */
    public long hlen(String key) {
        Jedis jedis = null;
        boolean isBroken = false;
        try {
            jedis = getResource();
            return jedis.hlen(key);
        } catch (Exception e) {
            isBroken = true;
            throw e;
        } finally {
            closeResource(jedis, isBroken);
        }
    }
}
