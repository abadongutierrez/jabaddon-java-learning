package com.jabaddon.learning.spring.springscopes;

import org.springframework.stereotype.Component;

@Component
public class ComponentB {
    private final MyPrototypeComponent myPrototypeComponent;
    private final MySingletonComponent mySingletonComponent;

    public ComponentB(MyPrototypeComponent myPrototypeComponent, MySingletonComponent mySingletonComponent) {
        this.myPrototypeComponent = myPrototypeComponent;
        this.mySingletonComponent = mySingletonComponent;
    }

    public MyPrototypeComponent getMyPrototypeComponent() {
        return myPrototypeComponent;
    }

    public MySingletonComponent getMySingletonComponent() {
        return mySingletonComponent;
    }
}
