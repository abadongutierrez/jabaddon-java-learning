package com.jabaddon.java.accessmodifiers.classmodifiers.packageb;

import com.jabaddon.java.accessmodifiers.classmodifiers.packagea.MyPublicClass;

public class MyClassUsingPublicClassFromPackageA {
    private final MyPublicClass myPublicClass;

    public MyClassUsingPublicClassFromPackageA(MyPublicClass myPublicClass) {
        this.myPublicClass = myPublicClass;
    }

    public MyPublicClass getMyPublicClass() {
        return myPublicClass;
    }
}
