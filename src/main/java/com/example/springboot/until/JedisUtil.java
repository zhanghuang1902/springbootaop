package com.example.springboot.until;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * ClassName:RediaHashUntil
 * Package:com.example.springboot.until
 * Description:
 *
 * @date:2020/2/25 22:25
 * @author:zh
 */
@Component
public class JedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private JedisPool jedisPool;

    public void setHash(String key, String filedKey, String value){
        HashOperations<String, String, Object> hashRedis = redisTemplate.opsForHash();
        hashRedis.put(key,filedKey, value);
    }

    public String getHash(String key, String filedkey){
        return (String) redisTemplate.opsForHash().get(key, filedkey);
    }

    public void setHashKey(String key, String value,int db){
        Jedis resource = null;
        try {
            resource = jedisPool.getResource();
            resource.select(db);
            resource.set(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            returnResource(jedisPool, resource);
        }
    }

    public  String getHashKey(String key,int indexdb) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            returnResource(jedisPool, jedis);
        }
        return value;
    }

    public String setex(String key, int seconds, String value) {
        Jedis jedis = getJedis();
        return jedis.setex(key, seconds, value);
    }

    private Jedis getJedis() {
       return jedisPool.getResource();
    }

    private void returnResource(JedisPool jedisPool, Jedis resource) {
        if (resource != null) {
            jedisPool.returnResource(resource);
        }
    }
}
