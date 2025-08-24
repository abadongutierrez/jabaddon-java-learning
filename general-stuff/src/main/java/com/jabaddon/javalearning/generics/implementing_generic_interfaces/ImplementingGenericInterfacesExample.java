package com.jabaddon.javalearning.generics.implementing_generic_interfaces;

import java.util.Objects;

public class ImplementingGenericInterfacesExample {
}

interface Shippable<T> {
    void ship(T t);
}

class Box {}

// The first is to specify the generic type in the class.
class ShippableBox implements Shippable<Box> {
    public void ship(Box box) {

    }
}

// The next way is to create a generic class.
class ShippableGeneric<U> implements Shippable<U> {
    public void ship(U t) {

    }
}

// The final way is to not use generics at all.
class ShippableOldWay implements Shippable {
    public void ship(Object t) {

    }
}