package com.learn.java.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 直接通过Spring 上下文获取SpringBean,Spring容器启动后需要注入ApplicationContext
 * @Description:
 * @Author:Sine renfs
 * @Date:Feb 5, 2018 6:55:35 PM
 *
= */
@Slf4j
@Service
public class SpringBeanUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    public static void setContext(ApplicationContext contextinject) {
        if (context != null) {
            return;
        }
        context = contextinject;
    }

    public static Object getBeanByName(String beanName) {
        return null == context ? null : context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }

    public static <T> T getBean(String name, Class<T> type) {
        return context.getBean(name, type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
        log.info("应用程序上下文:{} {}", applicationContext.getApplicationName(),"初始化完成");
    }


}
