package com.jabaddon.spring_bean_lifecycle.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BeanB that has a circular dependency with BeanA
 * Spring resolves this using setter injection
 */
@Component
public class BeanB {

    private BeanA beanA;

    public BeanB() {
        System.out.println("   🔄 BeanB: Constructor called (beanA is null at this point)");
    }

    /**
     * Setter injection allows Spring to resolve circular dependencies
     * Spring creates both beans first, then injects dependencies later
     */
    @Autowired
    public void setBeanA(BeanA beanA) {
        System.out.println("   🔄 BeanB: BeanA injected via setter");
        this.beanA = beanA;
    }

    public void doSomethingElse() {
        System.out.println("   🔄 BeanB: Executing business logic");
        System.out.println("   🔄 BeanB: Calling BeanA...");
        beanA.respondToBeanB();
    }

    public void startProcess() {
        System.out.println("   🔄 BeanB: Starting process");
        beanA.doSomething();
    }
}
