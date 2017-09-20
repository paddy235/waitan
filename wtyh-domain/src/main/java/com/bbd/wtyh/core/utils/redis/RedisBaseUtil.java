package com.bbd.wtyh.core.utils.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * redis 基础工具类
 *
 * @author Created by LiYao on 2017-09-11 15:02.
 */
class RedisBaseUtil {

    protected static final String PROPERTY_PATH = "config/db-config.properties";
    protected static final Logger LOGGER = LoggerFactory.getLogger(RedisBaseUtil.class);
    protected static JedisPool pool;

    private static void returnBrokenResource(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }

    private static void returnResource(Jedis jedis) {
        pool.returnResource(jedis);
    }

    protected static Jedis getResource() {
        return pool.getResource();
    }

    protected static void closeResource(Jedis jedis, boolean conectionBroken) {
        if (jedis == null) {
            return;
        }
        try {
            if (conectionBroken) {
                returnBrokenResource(jedis);
            } else {
                returnResource(jedis);
            }
        } catch (Exception e) {
            LOGGER.error("return back jedis failed, will fore close the jedis.", e);
            jedis.close();
        }
    }

    static {
        InputStream input = RedisBaseUtil.class.getClassLoader().getResourceAsStream(PROPERTY_PATH);
        if (input == null) {
            throw new IllegalArgumentException("[" + PROPERTY_PATH + "] not found");
        }
        Properties properties = new Properties();
        try {
            properties.load(input);
            JedisShardInfo shardInfo = createJedisShardInfo(properties);
            JedisPoolConfig config = createJedisPoolConfig(properties);
            pool = new JedisPool(config, shardInfo.getHost(), shardInfo.getPort(), shardInfo.getTimeout(), shardInfo.getPassword());
        } catch (IOException e) {
            LOGGER.error("load property[{}] error.", e);
        }
    }

    private static JedisShardInfo createJedisShardInfo(Properties properties) {
        String host = properties.getProperty("redis.host");
        int port = Integer.parseInt(properties.getProperty("redis.port"));
        String password = properties.getProperty("redis.password");
        String timeout = properties.getProperty("redis.timeout");
        JedisShardInfo shardInfo;
        if (StringUtils.isBlank(timeout)) {
            shardInfo = new JedisShardInfo(host, port);
        } else {
            shardInfo = new JedisShardInfo(host, port, Integer.parseInt(timeout));
        }
        shardInfo.setPassword(password);
        return shardInfo;
    }

    private static JedisPoolConfig createJedisPoolConfig(Properties properties) {
        JedisPoolConfig config = new JedisPoolConfig();
        String maxToal = properties.getProperty("redis.pool.maxTotal");
        if (StringUtils.isNotBlank(maxToal)) {
            config.setMaxTotal(Integer.valueOf(maxToal));
        }
        String maxIdle = properties.getProperty("redis.pool.maxIdle");
        if (StringUtils.isNotBlank(maxIdle)) {
            config.setMaxIdle(Integer.valueOf(maxIdle));
        }
        String maxWaitMillis = properties.getProperty("redis.pool.maxWait");
        if (StringUtils.isNotBlank(maxWaitMillis)) {
            config.setMaxWaitMillis(Long.valueOf(maxWaitMillis));
        }
        config.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("redis.pool.testOnReturn")));
        config.setTestWhileIdle(Boolean.parseBoolean(properties.getProperty("redis.pool.testWhileIdle")));
        return config;
    }

    protected static boolean arrayIsEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
}
