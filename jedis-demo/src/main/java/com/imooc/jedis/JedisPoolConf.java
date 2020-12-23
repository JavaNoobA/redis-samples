package com.imooc.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * JedisPool config
 *
 * @author pengfei.zhao
 * @date 2020/12/22 21:40
 */
public class JedisPoolConf {
    private static JedisPool jedisPool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(0);
        config.setMaxIdle(8);
        jedisPool = new JedisPool();
    }

    public static Jedis getResource(){
        return jedisPool.getResource();
    }
}
