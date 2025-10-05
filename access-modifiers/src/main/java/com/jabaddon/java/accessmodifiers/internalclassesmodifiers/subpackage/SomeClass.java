package com.jabaddon.java.accessmodifiers.internalclassesmodifiers.subpackage;

import com.jabaddon.java.accessmodifiers.internalclassesmodifiers.ClassWithProtectedInternalClass;

public class SomeClass {

    public void method() {
        // error: ClassWithProtectedConstructor(String) has protected access in ClassWithProtectedConstructor
        //ClassWithProtectedInternalClass.InternalProtectedClass instance =
        //        new ClassWithProtectedInternalClass().new InternalProtectedClass("JAbaddon");
    }

}
