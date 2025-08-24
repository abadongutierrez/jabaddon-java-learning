package com.jabaddon.learning.spring.springscopes;

import org.springframework.stereotype.Component;

@Component
public class ComponentA {
    private final MyPrototypeComponent myPrototypeComponent;
    private final MySingletonComponent mySingletonComponent;

    public ComponentA(MyPrototypeComponent myPrototypeComponent, MySingletonComponent mySingletonComponent) {
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
