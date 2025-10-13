# Spring Bean Lifecycle Demo

Este proyecto demuestra **todas las fases del ciclo de vida de un Bean en Spring**, desde la instanciación hasta la destrucción.

## Fases del Ciclo de Vida

### 1️⃣ Instanciación
Spring crea el bean ejecutando su constructor. Aquí se inyectan las dependencias del constructor (constructor injection).

```java
public MyBean() {
    System.out.println("1️⃣ INSTANCIACIÓN: Constructor ejecutado");
}
```

### 2️⃣ Inyección de Dependencias
Spring inyecta todas las dependencias declaradas (field injection con `@Autowired`, setter injection, etc.).

```java
@Autowired
public void setDependencyBean(DependencyBean dependencyBean) {
    System.out.println("2️⃣ INYECCIÓN DE DEPENDENCIAS: Setter injection ejecutado");
    this.dependencyBean = dependencyBean;
}
```

### 3️⃣ Configuración de Propiedades
Se asignan los valores de propiedades usando `@Value` o configuración via XML.

```java
@Value("${mybean.property:default-value}")
private String propertyValue;
```

### 4️⃣ Interfaces Awareness
Si el bean implementa interfaces "Aware", Spring ejecuta sus métodos:

- **BeanNameAware**: Proporciona el nombre del bean
- **ApplicationContextAware**: Proporciona acceso al contexto de Spring

```java
@Override
public void setBeanName(String name) {
    this.beanName = name;
    System.out.println("4️⃣ INTERFACES AWARENESS (BeanNameAware): Bean name es '" + name + "'");
}

@Override
public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
    System.out.println("4️⃣ INTERFACES AWARENESS (ApplicationContextAware): ApplicationContext inyectado");
}
```

### 5️⃣ Pre-inicialización (BeanPostProcessor)
Se ejecutan los métodos `postProcessBeforeInitialization()` de cualquier `BeanPostProcessor` registrado.

```java
@Override
public Object postProcessBeforeInitialization(Object bean, String beanName) {
    if (bean instanceof MyBean) {
        System.out.println("5️⃣ PRE-INICIALIZACIÓN (BeanPostProcessor): postProcessBeforeInitialization()");
    }
    return bean;
}
```

### 6️⃣ Inicialización
Aquí se ejecuta la lógica de inicialización en el siguiente orden:

1. **@PostConstruct**: Método anotado con `@PostConstruct`
2. **InitializingBean**: Método `afterPropertiesSet()` si se implementa `InitializingBean`
3. **Custom init**: Método init personalizado definido en `@Bean(initMethod="...")`

```java
@PostConstruct
public void postConstruct() {
    System.out.println("6️⃣ INICIALIZACIÓN (@PostConstruct): Método ejecutado");
}

@Override
public void afterPropertiesSet() {
    System.out.println("6️⃣ INICIALIZACIÓN (InitializingBean): afterPropertiesSet() ejecutado");
}

public void customInit() {
    System.out.println("6️⃣ INICIALIZACIÓN (Custom init): Método init personalizado ejecutado");
}
```

### 7️⃣ Post-inicialización (BeanPostProcessor)
Se ejecutan los métodos `postProcessAfterInitialization()` de los `BeanPostProcessor`.

```java
@Override
public Object postProcessAfterInitialization(Object bean, String beanName) {
    if (bean instanceof MyBean) {
        System.out.println("7️⃣ POST-INICIALIZACIÓN (BeanPostProcessor): postProcessAfterInitialization()");
    }
    return bean;
}
```

### 🎯 ¡El Bean está listo para usar!

En este punto, el bean está completamente inicializado y listo para ejecutar lógica de negocio.

### 8️⃣ Destrucción
Cuando el contexto se cierra, se ejecutan los métodos de destrucción en el siguiente orden:

1. **@PreDestroy**: Método anotado con `@PreDestroy`
2. **DisposableBean**: Método `destroy()` si se implementa `DisposableBean`
3. **Custom destroy**: Método destroy personalizado definido en `@Bean(destroyMethod="...")`

```java
@PreDestroy
public void preDestroy() {
    System.out.println("8️⃣ DESTRUCCIÓN (@PreDestroy): Método ejecutado");
}

@Override
public void destroy() {
    System.out.println("8️⃣ DESTRUCCIÓN (DisposableBean): destroy() ejecutado");
}

public void customDestroy() {
    System.out.println("8️⃣ DESTRUCCIÓN (Custom destroy): Método destroy personalizado ejecutado");
}
```

## Estructura del Proyecto

```
src/main/java/com/jabaddon/spring_bean_lifecycle/
├── SpringBeanLifecycleApplication.java  # Aplicación principal
├── MyBean.java                           # Bean con monitoreo completo del ciclo de vida
├── DependencyBean.java                   # Bean de dependencia
├── MyBeanPostProcessor.java              # BeanPostProcessor personalizado
└── BeanConfig.java                       # Configuración de Spring
```

## Cómo Ejecutar

```bash
mvn clean compile exec:java -Dexec.mainClass="com.jabaddon.spring_bean_lifecycle.SpringBeanLifecycleApplication"
```

## Salida Esperada

```
========================================
🚀 INICIANDO CONTEXTO DE SPRING
========================================

   🔧 DependencyBean: Constructor ejecutado
1️⃣ INSTANCIACIÓN: Constructor ejecutado
2️⃣ INYECCIÓN DE DEPENDENCIAS: Setter injection ejecutado
4️⃣ INTERFACES AWARENESS (BeanNameAware): Bean name es 'myBean'
4️⃣ INTERFACES AWARENESS (ApplicationContextAware): ApplicationContext inyectado
5️⃣ PRE-INICIALIZACIÓN (BeanPostProcessor): postProcessBeforeInitialization() para bean 'myBean'
6️⃣ INICIALIZACIÓN (@PostConstruct): Método anotado con @PostConstruct ejecutado
6️⃣ INICIALIZACIÓN (InitializingBean): afterPropertiesSet() ejecutado
   📋 Property value: ¡Valor configurado desde application.properties!
   📋 Dependency bean: ✅ inyectado
6️⃣ INICIALIZACIÓN (Custom init): Método init personalizado ejecutado
7️⃣ POST-INICIALIZACIÓN (BeanPostProcessor): postProcessAfterInitialization() para bean 'myBean'

========================================
✅ CONTEXTO INICIADO COMPLETAMENTE
========================================

🎯 ¡BEAN LISTO PARA USAR! Ejecutando lógica de negocio...
   Bean name: myBean
   Property value: ¡Valor configurado desde application.properties!
   Dependency: ¡Soy una dependencia inyectada!

========================================
🛑 CERRANDO CONTEXTO DE SPRING
========================================

8️⃣ DESTRUCCIÓN (@PreDestroy): Método anotado con @PreDestroy ejecutado
8️⃣ DESTRUCCIÓN (DisposableBean): destroy() ejecutado
8️⃣ DESTRUCCIÓN (Custom destroy): Método destroy personalizado ejecutado

========================================
❌ CONTEXTO CERRADO
========================================
```

## Conceptos Clave

- **BeanPostProcessor**: Permite interceptar la creación de beans y modificarlos antes o después de la inicialización
- **Aware interfaces**: Proporcionan acceso a infraestructura de Spring (contexto, nombre del bean, etc.)
- **@PostConstruct/@PreDestroy**: Anotaciones JSR-250 para métodos de inicialización y destrucción
- **InitializingBean/DisposableBean**: Interfaces callback para el ciclo de vida
- **initMethod/destroyMethod**: Métodos personalizados configurados en `@Bean`

## Orden de Ejecución

### Inicialización:
1. Constructor
2. Setter injection / Field injection
3. BeanNameAware.setBeanName()
4. ApplicationContextAware.setApplicationContext()
5. BeanPostProcessor.postProcessBeforeInitialization()
6. @PostConstruct
7. InitializingBean.afterPropertiesSet()
8. Custom initMethod
9. BeanPostProcessor.postProcessAfterInitialization()

### Destrucción:
1. @PreDestroy
2. DisposableBean.destroy()
3. Custom destroyMethod
