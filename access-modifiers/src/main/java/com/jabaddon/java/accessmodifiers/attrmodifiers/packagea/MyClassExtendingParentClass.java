package com.jabaddon.java.accessmodifiers.attrmodifiers.packagea;

class MyClassExtendingParentClass extends MyParentClass  {
    public MyClassExtendingParentClass(String privateString, String protectedString, String packageProtectedString, String publicString) {
        super(privateString, protectedString, packageProtectedString, publicString);
        someMethod();
    }

    private void someMethod() {
        System.out.println("I can read _packageProtectedString: " + _packageProtectedString);
        System.out.println("I can read _protectedString: " + _protectedString);
        System.out.println("I can read _publicString: " + _publicString);
        System.out.println("I can read getPrivateString() because it is package protected: " + getPrivateString());
    }
}
