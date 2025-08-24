package com.jabaddon.javalearning.spring;

public class Configuration {
//    @Bean
    public MyService myService() {
        return new MyService();
    }

    public MyComponent myComponent() {
        return new MyComponent();
    }
}
