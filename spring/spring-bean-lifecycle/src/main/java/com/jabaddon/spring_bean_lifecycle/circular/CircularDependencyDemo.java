package com.jabaddon.spring_bean_lifecycle.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/**
 * Demo class to show how Spring resolves circular dependencies
 *
 * How Spring resolves circular dependencies:
 * 1. Spring creates BeanA instance (calls constructor)
 * 2. Spring creates BeanB instance (calls constructor)
 * 3. Spring injects BeanB into BeanA (via setter)
 * 4. Spring injects BeanA into BeanB (via setter)
 * 5. Both beans are now fully initialized and can reference each other
 *
 * IMPORTANT: Circular dependencies only work with SETTER injection, not constructor injection!
 * Constructor injection would cause a BeanCurrentlyInCreationException.
 */
@Component
public class CircularDependencyDemo {

    @Autowired
    private BeanA beanA;

    @Autowired
    private BeanB beanB;

    @PostConstruct
    public void demonstrateCircularDependency() {
        System.out.println("\n========================================");
        System.out.println("🔄 CIRCULAR DEPENDENCY RESOLUTION DEMO");
        System.out.println("========================================\n");

        System.out.println("📌 How Spring resolved the circular dependency:");
        System.out.println("   1. Created BeanA instance (constructor)");
        System.out.println("   2. Created BeanB instance (constructor)");
        System.out.println("   3. Injected BeanB into BeanA (setter)");
        System.out.println("   4. Injected BeanA into BeanB (setter)");
        System.out.println("   5. Both beans are now fully initialized!\n");

        System.out.println("📌 Testing the circular dependency:\n");
        beanB.startProcess();

        System.out.println("\n✅ Circular dependency successfully resolved by Spring!");
        System.out.println("========================================\n");
    }
}
