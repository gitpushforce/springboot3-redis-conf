package com.example.redisconf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Value("${expiry}")
    private Integer expiry;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Object getRedisValue(String key) {
        try {
            return getRedis(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void setRedisValue(String key, Object value) {
        try {
            setRedis(key, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // get value of determined key
    private Object getRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    private void setRedis(String key, Object value) {
        // set value to determined key
        redisTemplate.opsForValue().set(key, value);
        // set expiration time in seconds to determined key
        redisTemplate.expire(key, expiry, TimeUnit.SECONDS);
    }
}
