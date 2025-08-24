package com.jabaddon.javalearning.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericPromiseExample {
    public static void main(String[] args) {
        List<Integer> myIntegers = new ArrayList<>();
        myIntegers.add(1);
        myIntegers.add(Integer.valueOf(34));
        // everything ok sa far, we have a list of integers that only accepts integers
        // but what if ...
//        List<Object> myObjects = myIntegers; // DOES NOT COMPILE! the compiler is protecting us from shooting at our foot!
//        myObjects.add("Look ma! a String!");

        // What if instead...
        List<?> myListOfWhateverObjects = myIntegers;
//        myListOfWhateverObjects.add("Hola"); // DOES NOT COMPILE! the compiler is still protecting us

        // What if instead...
        List<? super Integer> other = myIntegers;
        other.add(1);
//        other.add(new Object());
    }
}
