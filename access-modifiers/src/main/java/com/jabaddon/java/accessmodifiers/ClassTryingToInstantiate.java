package com.jabaddon.java.accessmodifiers;

public class ClassTryingToInstantiate {

    private void someMethod() {
        // NOTE: Cannot instantiate MyClassWithPrivateConstructor because its private constructor
        //MyClassWithPrivateConstructor clazz = new MyClassWithPrivateConstructor();
    }
}
