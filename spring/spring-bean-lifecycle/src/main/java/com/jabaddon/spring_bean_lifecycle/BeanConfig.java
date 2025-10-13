package com.jabaddon.spring_bean_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration to register MyBean with custom init and destroy methods
 */
@Configuration
public class BeanConfig {

    /**
     * Registers MyBean with custom initialization and destruction methods
     * initMethod: executes after @PostConstruct and afterPropertiesSet()
     * destroyMethod: executes after @PreDestroy and destroy()
     */
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public MyBean myBean() {
        return new MyBean();
    }
}
