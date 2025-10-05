package com.jabaddon.java.accessmodifiers.internalclassesmodifiers.subpackage;

import com.jabaddon.java.accessmodifiers.internalclassesmodifiers.ClassWithProtectedInternalClass;


public class Subclass extends ClassWithProtectedInternalClass {

    public void method() {
        // successs: because Subclass is a subclass of ClassWithProtectedInternalClass
        InternalProtectedClass instance =
                new ClassWithProtectedInternalClass().new InternalProtectedClass("JAbaddon");
    }
}
