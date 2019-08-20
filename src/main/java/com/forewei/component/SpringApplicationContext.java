package com.forewei.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author forewei
 * @date 2019-8-18 11:46
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T>  T getBean(Class<T> bean) {
        return applicationContext.getBean(bean);
    }

    /**
     * 通过名称获取
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static ApplicationContext getContext() {
        return applicationContext;
    }
}
