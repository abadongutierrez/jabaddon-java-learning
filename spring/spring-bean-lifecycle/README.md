# Spring Bean Lifecycle Demo

This project demonstrates **all phases of the Spring Bean lifecycle**, from instantiation to destruction.

## Lifecycle Phases

### 1️⃣ Instantiation
Spring creates the bean by executing its constructor. Constructor dependencies are injected here (constructor injection).

```java
public MyBean() {
    System.out.println("1️⃣ INSTANTIATION: Constructor executed");
}
```

### 2️⃣ Dependency Injection
Spring injects all declared dependencies (field injection with `@Autowired`, setter injection, etc.).

```java
@Autowired
public void setDependencyBean(DependencyBean dependencyBean) {
    System.out.println("2️⃣ DEPENDENCY INJECTION: Setter injection executed");
    this.dependencyBean = dependencyBean;
}
```

### 3️⃣ Property Configuration
Property values are assigned using `@Value` or XML configuration.

```java
@Value("${mybean.property:default-value}")
public void setPropertyValue(String propertyValue) {
    System.out.println("3️⃣ PROPERTY CONFIGURATION: @Value property injected via setter");
    this.propertyValue = propertyValue;
}
```

### 4️⃣ Interfaces Awareness
If the bean implements "Aware" interfaces, Spring executes their methods:

- **BeanNameAware**: Provides the bean name
- **ApplicationContextAware**: Provides access to the Spring context

```java
@Override
public void setBeanName(String name) {
    this.beanName = name;
    System.out.println("4️⃣ INTERFACES AWARENESS (BeanNameAware): Bean name is '" + name + "'");
}

@Override
public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
    System.out.println("4️⃣ INTERFACES AWARENESS (ApplicationContextAware): ApplicationContext injected");
}
```

### 5️⃣ Pre-initialization (BeanPostProcessor)
The `postProcessBeforeInitialization()` methods of any registered `BeanPostProcessor` are executed.

```java
@Override
public Object postProcessBeforeInitialization(Object bean, String beanName) {
    if (bean instanceof MyBean) {
        System.out.println("5️⃣ PRE-INITIALIZATION (BeanPostProcessor): postProcessBeforeInitialization()");
    }
    return bean;
}
```

### 6️⃣ Initialization
Initialization logic is executed in the following order:

1. **@PostConstruct**: Method annotated with `@PostConstruct`
2. **InitializingBean**: `afterPropertiesSet()` method if `InitializingBean` is implemented
3. **Custom init**: Custom init method defined in `@Bean(initMethod="...")`

```java
@PostConstruct
public void postConstruct() {
    System.out.println("6️⃣ INITIALIZATION (@PostConstruct): Method executed");
}

@Override
public void afterPropertiesSet() {
    System.out.println("6️⃣ INITIALIZATION (InitializingBean): afterPropertiesSet() executed");
}

public void customInit() {
    System.out.println("6️⃣ INITIALIZATION (Custom init): Custom init method executed");
}
```

### 7️⃣ Post-initialization (BeanPostProcessor)
The `postProcessAfterInitialization()` methods of `BeanPostProcessor` are executed.

```java
@Override
public Object postProcessAfterInitialization(Object bean, String beanName) {
    if (bean instanceof MyBean) {
        System.out.println("7️⃣ POST-INITIALIZATION (BeanPostProcessor): postProcessAfterInitialization()");
    }
    return bean;
}
```

### 🎯 The Bean is ready to use!

At this point, the bean is fully initialized and ready to execute business logic.

### 8️⃣ Destruction
When the context is closed, destruction methods are executed in the following order:

1. **@PreDestroy**: Method annotated with `@PreDestroy`
2. **DisposableBean**: `destroy()` method if `DisposableBean` is implemented
3. **Custom destroy**: Custom destroy method defined in `@Bean(destroyMethod="...")`

```java
@PreDestroy
public void preDestroy() {
    System.out.println("8️⃣ DESTRUCTION (@PreDestroy): Method executed");
}

@Override
public void destroy() {
    System.out.println("8️⃣ DESTRUCTION (DisposableBean): destroy() executed");
}

public void customDestroy() {
    System.out.println("8️⃣ DESTRUCTION (Custom destroy): Custom destroy method executed");
}
```

## Circular Dependency Resolution

This project also demonstrates how Spring resolves circular dependencies between beans.

### What is a Circular Dependency?

A circular dependency occurs when two or more beans depend on each other. For example:
- BeanA depends on BeanB
- BeanB depends on BeanA

### How Spring Resolves Circular Dependencies

Spring can resolve circular dependencies **only with setter injection**, not with constructor injection.

The resolution process:
1. Spring creates BeanA instance (calls constructor, BeanB is null)
2. Spring creates BeanB instance (calls constructor, BeanA is null)
3. Spring injects BeanB into BeanA (via setter)
4. Spring injects BeanA into BeanB (via setter)
5. Both beans are now fully initialized and can reference each other

### Important Notes

- **Spring Boot 3.x+ prohibits circular dependencies by default**
- To allow them, you must set `spring.main.allow-circular-references=true`
- Circular dependencies only work with **setter injection**, not constructor injection
- Constructor injection would cause a `BeanCurrentlyInCreationException`
- Circular dependencies are generally discouraged as they indicate a design issue

### Example Code

**BeanA.java:**
```java
@Component
public class BeanA {
    private BeanB beanB;

    @Autowired  // Setter injection required for circular dependencies
    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }
}
```

**BeanB.java:**
```java
@Component
public class BeanB {
    private BeanA beanA;

    @Autowired  // Setter injection required for circular dependencies
    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
```

See the `circular` package for a complete working example.

## Project Structure

```
src/main/java/com/jabaddon/spring_bean_lifecycle/
├── SpringBeanLifecycleApplication.java  # Main application
├── MyBean.java                           # Bean with complete lifecycle monitoring
├── DependencyBean.java                   # Dependency bean
├── MyBeanPostProcessor.java              # Custom BeanPostProcessor
├── BeanConfig.java                       # Spring configuration
└── circular/
    ├── BeanA.java                        # Bean with circular dependency
    ├── BeanB.java                        # Bean with circular dependency
    └── CircularDependencyDemo.java       # Demo of circular dependency resolution
```

## How to Run

```bash
mvn clean compile exec:java -Dexec.mainClass="com.jabaddon.spring_bean_lifecycle.SpringBeanLifecycleApplication"
```

## Expected Output

```
========================================
🚀 STARTING SPRING CONTEXT
========================================

   🔧 DependencyBean: Constructor executed
1️⃣ INSTANTIATION: Constructor executed
2️⃣ DEPENDENCY INJECTION: Setter injection executed
3️⃣ PROPERTY CONFIGURATION: @Value property injected via setter
4️⃣ INTERFACES AWARENESS (BeanNameAware): Bean name is 'myBean'
4️⃣ INTERFACES AWARENESS (ApplicationContextAware): ApplicationContext injected
5️⃣ PRE-INITIALIZATION (BeanPostProcessor): postProcessBeforeInitialization() for bean 'myBean'
6️⃣ INITIALIZATION (@PostConstruct): Method annotated with @PostConstruct executed
6️⃣ INITIALIZATION (InitializingBean): afterPropertiesSet() executed
   📋 Property value: Value configured from application.properties!
   📋 Dependency bean: ✅ injected
6️⃣ INITIALIZATION (Custom init): Custom init method executed
7️⃣ POST-INITIALIZATION (BeanPostProcessor): postProcessAfterInitialization() for bean 'myBean'

========================================
✅ CONTEXT FULLY STARTED
========================================

🎯 BEAN READY TO USE! Executing business logic...
   Bean name: myBean
   Property value: Value configured from application.properties!
   Dependency: I'm an injected dependency!

========================================
🛑 CLOSING SPRING CONTEXT
========================================

8️⃣ DESTRUCTION (@PreDestroy): Method annotated with @PreDestroy executed
8️⃣ DESTRUCTION (DisposableBean): destroy() executed
8️⃣ DESTRUCTION (Custom destroy): Custom destroy method executed

========================================
❌ CONTEXT CLOSED
========================================
```

## Key Concepts

- **BeanPostProcessor**: Allows intercepting bean creation and modifying them before or after initialization
- **Aware interfaces**: Provide access to Spring infrastructure (context, bean name, etc.)
- **@PostConstruct/@PreDestroy**: JSR-250 annotations for initialization and destruction methods
- **InitializingBean/DisposableBean**: Lifecycle callback interfaces
- **initMethod/destroyMethod**: Custom methods configured in `@Bean`

## Execution Order

### Initialization:
1. Constructor
2. Setter injection / Field injection
3. Property Configuration (@Value)
4. BeanNameAware.setBeanName()
5. ApplicationContextAware.setApplicationContext()
6. BeanPostProcessor.postProcessBeforeInitialization()
7. @PostConstruct
8. InitializingBean.afterPropertiesSet()
9. Custom initMethod
10. BeanPostProcessor.postProcessAfterInitialization()

### Destruction:
1. @PreDestroy
2. DisposableBean.destroy()
3. Custom destroyMethod
