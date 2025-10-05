package com.jabaddon.java.accessmodifiers.internalclassesmodifiers;

public class SomeClass {

    public void method() {
        ClassWithProtectedInternalClass.InternalProtectedClass instance =
                new ClassWithProtectedInternalClass().new InternalProtectedClass("JAbaddon");
    }
}
