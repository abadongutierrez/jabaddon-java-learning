package com.jabaddon.spring_bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Custom BeanPostProcessor to demonstrate phases 5 and 7 of the lifecycle
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 5️⃣ PRE-INITIALIZATION - Executes BEFORE initialization methods
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("5️⃣ PRE-INITIALIZATION (BeanPostProcessor): postProcessBeforeInitialization() for bean '" + beanName + "'");
        }
        return bean;
    }

    // 7️⃣ POST-INITIALIZATION - Executes AFTER initialization methods
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean) {
            System.out.println("7️⃣ POST-INITIALIZATION (BeanPostProcessor): postProcessAfterInitialization() for bean '" + beanName + "'");
        }
        return bean;
    }
}
