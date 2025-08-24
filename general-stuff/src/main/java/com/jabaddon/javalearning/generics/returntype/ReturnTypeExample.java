package com.jabaddon.javalearning.generics.returntype;

import java.util.ArrayList;
import java.util.List;

public class ReturnTypeExample {
    String strValue = "hola";
    CharSequence charSequence = "hola";
}

class Mamal {
    public List<CharSequence> play() {
        return null;
    }

    public CharSequence sleep() {
        return null;
    }
}

class Monkey extends Mamal {
    @Override
    public ArrayList<CharSequence> play() {
        return null;
    }
}

class Goat extends Mamal {
    // For the return types to be covariant, the generic type parameter must match.!
//    @Override
//    public List<String> play() { // DOES NOT COMPILE
//        return null;
//    }


    // This compiles because String is a subtype of CharSequence but when talking about Generic type is different
    // covariance applies to the return type, just not the generic parameter type.
    @Override
    public String sleep() {
        return null;
    }
}
