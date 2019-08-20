package com.forewei.util;

import org.springframework.beans.BeanUtils;

/**
 * @Author forewei
 * @date 2019-8-19 13:04
 */
public class BeanObjectUtils {

    public static <T> T copyTo(Object source,Class<T> targetClass) {
        T bean = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(source, bean);
        return bean;
    }

    public static <T> T copyTo(Object source,Class<T> targetClass,String...names) {
        T bean = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(source, bean, names);
        return bean;
    }

}
