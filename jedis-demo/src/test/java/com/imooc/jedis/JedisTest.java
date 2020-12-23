package com.imooc.jedis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author pengfei.zhao
 * @date 2020/12/22 21:35
 */
public class JedisTest {

    Jedis jedis = null;

    @Before
    public void init() {
        jedis = new Jedis("127.0.0.1", 6379);
        String pong = jedis.ping();
        Assert.assertEquals(pong, "PONG");
    }

    @Test
    public void testString(){
        // 添加一条string 记录
        jedis.set("name", "zhangsan");
        Assert.assertEquals(jedis.get("name"), "zhangsan");

        jedis.set("user:1:name", "erudev");
        Assert.assertEquals(jedis.get("user:1:name"), "erudev");
    }

    @After
    public void close() {
        if (null != jedis) {
            jedis.close();
        }
    }

}
