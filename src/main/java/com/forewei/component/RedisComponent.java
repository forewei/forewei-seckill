package com.forewei.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 组件
 *
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Component
public class RedisComponent {

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 添加
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 以过期时间添加
     *
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     */
    public void setExpire(String key, Object value, long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    /**
     * 删除
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }


}
