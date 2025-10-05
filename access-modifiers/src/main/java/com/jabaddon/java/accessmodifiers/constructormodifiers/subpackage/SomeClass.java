package com.jabaddon.java.accessmodifiers.constructormodifiers.subpackage;

import com.jabaddon.java.accessmodifiers.constructormodifiers.ClassWithProtectedConstructor;

public class SomeClass {

    public void method() {
        // error: ClassWithProtectedConstructor(String) has protected access in ClassWithProtectedConstructor
        //ClassWithProtectedConstructor instance = new ClassWithProtectedConstructor("JAbaddon");
    }
}
