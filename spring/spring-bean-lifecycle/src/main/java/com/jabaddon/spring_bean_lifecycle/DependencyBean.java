package com.jabaddon.spring_bean_lifecycle;

import org.springframework.stereotype.Component;

/**
 * Simple dependency bean to demonstrate dependency injection
 */
@Component
public class DependencyBean {

    public DependencyBean() {
        System.out.println("   🔧 DependencyBean: Constructor executed");
    }

    public String getMessage() {
        return "I'm an injected dependency!";
    }
}
