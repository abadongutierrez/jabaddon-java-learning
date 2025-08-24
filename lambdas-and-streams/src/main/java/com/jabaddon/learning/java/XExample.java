package com.jabaddon.learning.java;

public class XExample {
    public static void main(String[] args) {
        MyNumber tree = new MyNumber(3);
        MyNumber two = new MyNumber(2);
        MyNumber five = new MyNumber(5);
        System.out.println(tree.plus(two).equals(tree));
    }

    private static class MyNumber {
        private final int value;

        public MyNumber(int i) {
            this.value = i;
        }

        public MyNumber plus(MyNumber other) {
            return new MyNumber(value + other.value);
        }

        public boolean equals(MyNumber other) {
            return value == other.value;
        }
    }
}
