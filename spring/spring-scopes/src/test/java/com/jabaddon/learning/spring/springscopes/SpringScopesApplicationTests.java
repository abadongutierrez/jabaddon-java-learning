package com.jabaddon.learning.spring.springscopes;

import com.jabaddon.otherpackage.MyLostComponent;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringScopesApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringScopesApplicationTests.class);

    @Autowired
    private ComponentA componentA;

    @Autowired
    private ComponentB componentB;

    @Autowired
    private ComponentC componentC;

    @Autowired
    private MyPrototypeComponent myPrototypeComponent;

    @Autowired(required = false)
    private MyLostComponent myLostComponent;

    @Test
    void prototypeInjectionDoesNotGiveSameInstance() {
        LOGGER.debug("{}", componentA.getMyPrototypeComponent());
        LOGGER.debug("{}", componentB.getMyPrototypeComponent());
        assertThat(componentA.getMyPrototypeComponent()).isNotSameAs(componentB.getMyPrototypeComponent());
        assertThat(componentB.getMyPrototypeComponent()).isNotSameAs(componentC.getMyPrototypeComponent());
        assertThat(componentA.getMyPrototypeComponent()).isNotSameAs(componentC.getMyPrototypeComponent());
    }

    @Test
    void singletonInjectionGiveSameInstance() {
        assertThat(componentA.getMySingletonComponent()).isSameAs(componentB.getMySingletonComponent());
        assertThat(componentB.getMySingletonComponent()).isSameAs(componentC.getMySingletonComponent());
        assertThat(componentA.getMySingletonComponent()).isSameAs(componentC.getMySingletonComponent());
    }

    @Test
    void componentsOutsideSpringBootAppPackageAreNotFound() {
        assertThat(myLostComponent).isNull();
    }

}
