package com.jabaddon.spring_bean_lifecycle.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BeanA that has a circular dependency with BeanB
 * Spring resolves this using setter injection
 */
@Component
public class BeanA {

    private BeanB beanB;

    public BeanA() {
        System.out.println("   🔄 BeanA: Constructor called (beanB is null at this point)");
    }

    /**
     * Setter injection allows Spring to resolve circular dependencies
     * Spring creates BeanA first, then injects BeanB later
     */
    @Autowired
    public void setBeanB(BeanB beanB) {
        System.out.println("   🔄 BeanA: BeanB injected via setter");
        this.beanB = beanB;
    }

    public void doSomething() {
        System.out.println("   🔄 BeanA: Executing business logic");
        System.out.println("   🔄 BeanA: Calling BeanB...");
        beanB.doSomethingElse();
    }

    public void respondToBeanB() {
        System.out.println("   🔄 BeanA: Responding to BeanB's call");
    }
}
