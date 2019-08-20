package com.forewei.util;

import com.alibaba.fastjson.JSON;
import com.forewei.component.SpringApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * redis缓存工具类
 *
 * @Author forewei
 * @date 2019-8-18 11:43
 */
public class RedisCacheUtils {

    private synchronized static StringRedisTemplate getRedisTemplate() {
        try {
            return SpringApplicationContext.getBean(StringRedisTemplate.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String serialize(Object value) {
        return JSON.toJSONString(value);
    }

    private static <T> T unserialize(Class<T> typeClass, String text) {
        try {
            return JSON.parseObject(text, typeClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> List<T> unserializeArray(Class<T> typeClass, String text) {
        try {
            return JSON.parseArray(text, typeClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * 获取数据
     *
     * @param typeClass
     * @param key
     * @return
     */
    public static <T> T getObject(Class<T> typeClass, String key) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return null;
        }
        String str = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return unserialize(typeClass, str);
    }

    /**
     * 批量获取
     *
     * @param typeClass
     * @param keys
     * @return
     */
    public static <T> List<T> getObjectList(Class<T> typeClass, List<String> keys) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return new ArrayList<>();
        }
        List<String> multiGets = redisTemplate.opsForValue().multiGet(keys);
        if (multiGets == null || multiGets.size() == 0) {
            return new ArrayList<>();
        }
        return multiGets
                .stream()
                .filter(text -> !StringUtils.isEmpty(text))
                .map(text -> unserialize(typeClass, text))
                .filter(data -> data != null)
                .collect(Collectors.toList());
    }

    public static <T> List<T> getObjectList(Class<T> typeClass, String key) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return new ArrayList<>();
        }
        String str = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(str)) {
            return new ArrayList<>();
        }
        return unserializeArray(typeClass, str);
    }

    public static void putObject(String key, Object value, long time) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return;
        }
        if (time <= 0) {
            putObject(key, value);
            return;
        }
        String serialize = serialize(value);
        redisTemplate.opsForValue().set(key, serialize, time, TimeUnit.SECONDS);
    }

    public static void putObject(String key, Object value) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return;
        }
        String serialize = serialize(value);
        redisTemplate.opsForValue().set(key, serialize);
    }

    /**
     * 批量添加
     *
     * @param keys
     * @param values
     */
    public static void putObjectList(List<String> keys, List<?> values) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return;
        }
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = serialize(values.get(i));
            data.put(key, value);
        }
        redisTemplate.opsForValue().multiSet(data);
    }

    public static void putObjectList(Map<String, Object> values) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return;
        }
        Map<String, String> data = new HashMap<>();
        values.forEach((key, value) -> {
            String object = serialize(value);
            data.put(key, object);
        });
        redisTemplate.opsForValue().multiSet(data);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public static void delete(String key) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return;
        }
        redisTemplate.delete(key);
    }


    /**
     * 删除缓存
     *
     * @param keys
     */
    public static void delete(List<String> keys) {
        StringRedisTemplate redisTemplate = getRedisTemplate();
        if (redisTemplate == null) {
            return;
        }
        redisTemplate.delete(keys);
    }
}
