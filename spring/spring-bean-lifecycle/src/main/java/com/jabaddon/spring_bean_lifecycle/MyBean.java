package com.jabaddon.spring_bean_lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Bean that demonstrates all phases of the Spring Bean lifecycle
 */
public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String beanName;
    private ApplicationContext applicationContext;

    // 3️⃣ PROPERTY CONFIGURATION with @Value
    private String propertyValue;

    // Dependency for injection
    private DependencyBean dependencyBean;

    // 1️⃣ INSTANTIATION - Constructor
    public MyBean() {
        System.out.println("1️⃣ INSTANTIATION: Constructor executed");
    }

    // 2️⃣ DEPENDENCY INJECTION - Setter injection
    @Autowired
    public void setDependencyBean(DependencyBean dependencyBean) {
        System.out.println("2️⃣ DEPENDENCY INJECTION: Setter injection executed");
        this.dependencyBean = dependencyBean;
    }

    // 3️⃣ PROPERTY CONFIGURATION - Setter injection with @Value
    @Value("${mybean.property:default-value}")
    public void setPropertyValue(String propertyValue) {
        System.out.println("3️⃣ PROPERTY CONFIGURATION: @Value property injected via setter");
        this.propertyValue = propertyValue;
    }

    // 4️⃣ INTERFACES AWARENESS - BeanNameAware
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("4️⃣ INTERFACES AWARENESS (BeanNameAware): Bean name is '" + name + "'");
    }

    // 4️⃣ INTERFACES AWARENESS - ApplicationContextAware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        System.out.println("4️⃣ INTERFACES AWARENESS (ApplicationContextAware): ApplicationContext injected");
    }

    // 6️⃣ INITIALIZATION - @PostConstruct (executes first)
    @PostConstruct
    public void postConstruct() {
        System.out.println("6️⃣ INITIALIZATION (@PostConstruct): Method annotated with @PostConstruct executed");
    }

    // 6️⃣ INITIALIZATION - InitializingBean.afterPropertiesSet()
    @Override
    public void afterPropertiesSet() {
        System.out.println("6️⃣ INITIALIZATION (InitializingBean): afterPropertiesSet() executed");
        System.out.println("   📋 Property value: " + propertyValue);
        System.out.println("   📋 Dependency bean: " + (dependencyBean != null ? "✅ injected" : "❌ not injected"));
    }

    // 6️⃣ INITIALIZATION - Custom init method (defined in @Bean)
    public void customInit() {
        System.out.println("6️⃣ INITIALIZATION (Custom init): Custom init method executed");
    }

    // Business method to demonstrate that the bean is ready
    public void doSomething() {
        System.out.println("\n🎯 BEAN READY TO USE! Executing business logic...");
        System.out.println("   Bean name: " + beanName);
        System.out.println("   Property value: " + propertyValue);
        System.out.println("   Dependency: " + dependencyBean.getMessage());
    }

    // 8️⃣ DESTRUCTION - @PreDestroy (executes first)
    @PreDestroy
    public void preDestroy() {
        System.out.println("8️⃣ DESTRUCTION (@PreDestroy): Method annotated with @PreDestroy executed");
    }

    // 8️⃣ DESTRUCTION - DisposableBean.destroy()
    @Override
    public void destroy() {
        System.out.println("8️⃣ DESTRUCTION (DisposableBean): destroy() executed");
    }

    // 8️⃣ DESTRUCTION - Custom destroy method
    public void customDestroy() {
        System.out.println("8️⃣ DESTRUCTION (Custom destroy): Custom destroy method executed");
    }
}
