package com.jabaddon.java.accessmodifiers.attrmodifiers.packagea;

public class MyParentClass {
    private final String _privateString;
    protected final String _protectedString;
    final String _packageProtectedString;
    public final String _publicString;

    public MyParentClass(String privateString, String protectedString, String packageProtectedString, String publicString) {
        _privateString = privateString;
        _protectedString = protectedString;
        _packageProtectedString = packageProtectedString;
        _publicString = publicString;
    }

    String getPrivateString() {
        return _privateString;
    }
}
