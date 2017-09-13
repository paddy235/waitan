package com.bbd.wtyh.core.utils.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 字符串操作工具类
 *
 * @author Created by LiYao on 2017-09-11 15:09.
 */
@SuppressWarnings("unused")
class StringOperationUtil extends KeyOperationUtil {

    /**
     * 用于设置给定 key 的值。如果 key 已经存储其他值， SET 就覆写旧值。
     *
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        set(key.getBytes(), value.getBytes());
    }

    protected static void set(byte[] key, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于获取指定 key 的值。如果 key 不存在，返回 null 。
     *
     * @param key
     * @return 返回 key 的值，如果 key 不存在时，返回 null。
     */
    public static String get(String key) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.get(key);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于获取存储在指定 key 中字符串的子字符串。字符串的截取范围由 start 和 end 两个偏移量决定(包括 start 和 end 在内)。
     *
     * @param key
     * @param start
     * @param end
     * @return 截取得到的子字符串。
     */
    public static String getrange(String key, int start, int end) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.getrange(key, start, end);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于设置指定 key 的值，并返回 key 的旧值。
     *
     * @param key
     * @param newValue
     * @return 返回给定 key 的旧值。 当 key 没有旧值时，即 key 不存在时，返回 null 。
     */
    public static String getset(String key, String newValue) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.getSet(key, newValue);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 返回所有(一个或多个)给定 key 的值。 如果给定的 key 里面，有某个 key 不存在，那么这个 key 返回特殊值 nil 。
     *
     * @param keys
     * @return 一个包含所有给定 key 的值的列表。
     */
    public static List<String> mget(String... keys) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.mget(keys);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 为指定的 key 设置值及其过期时间。如果 key 已经存在， SETEX 命令将会替换旧的值。
     *
     * @param key
     * @param seconds
     * @param value
     */
    public static void setex(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.setex(key, seconds, value);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将 key 中储存的数字加上指定的增量值。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令。
     *
     * @param key
     * @param incremental
     *
     * @return 加上指定的增量值之后， key 的值。
     */
    public static long incrby(String key, long incremental) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.incrBy(key, incremental);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将 key 所储存的值减去指定的减量值。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 DECRBY 操作。
     *
     * @param key
     * @param decrement
     * @return 减去指定减量值之后， key 的值。
     */
    public static long decrby(String key, long decrement) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            return jedis.decrBy(key, decrement);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 用于为指定的 key 追加值。<br>
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。<br>
     * 如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样。
     *
     * @param key
     * @param value
     */
    public static void append(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.append(key, value);
        } catch (Exception e) {
            returnBrokenResource(jedis);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }
}
