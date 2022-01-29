package com.jabaddon.java.accessmodifiers.attrmodifiers.packageb;

import com.jabaddon.java.accessmodifiers.attrmodifiers.packagea.MyParentClass;

public class MyClassExtendingParentClassFromPackageA extends MyParentClass {
    public MyClassExtendingParentClassFromPackageA(String privateString, String protectedString, String packageProtectedString, String publicString) {
        super(privateString, protectedString, packageProtectedString, publicString);
        someMethod();
    }

    private void someMethod() {
        // cannot access: super._privateString
        // cannot access: super._packageProtectedString
        System.out.println("I can read _protectedString: " + super._protectedString);
        System.out.println("I can read _publicString: " + super._publicString);
    }
}
