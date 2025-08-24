package com.jabaddon.javalearning.general.trycatch;

public class TryCatchWeird {
    int method() {
        try {
            return 0;
        } finally {
            System.out.println("This will always execute");
            return 1;
        }
    }

    public static void main(String[] args) {
        TryCatchWeird main = new TryCatchWeird();
        int result = main.method();
        System.out.println("Result: " + result);
    }
}
