package com.jabaddon.java.accessmodifiers.internalclassesmodifiers;

public class ClassWithProtectedInternalClass {

    protected class InternalProtectedClass {
        private String name;

        public InternalProtectedClass(String name) {
            this.name = name;
        }
    }
}
