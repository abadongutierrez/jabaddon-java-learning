package com.jabaddon.java.accessmodifiers;

public class MyClassWithPrivateConstructor {
    // NOTE:
    // Usages of private constructors?
    private MyClassWithPrivateConstructor() {

    }

    public static void main(String[] args) {
        MyClassWithPrivateConstructor clazz = new MyClassWithPrivateConstructor();
    }
}
