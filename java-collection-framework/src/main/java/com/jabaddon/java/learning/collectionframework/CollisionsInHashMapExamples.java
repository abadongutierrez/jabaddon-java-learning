package com.jabaddon.java.learning.collectionframework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CollisionsInHashMapExamples {
    public static void main(String[] args) {
        Map<SomeKey, SomeValue> map = new HashMap<>();
        SomeKey key = new SomeKey(1);
        SomeValue value1 = new SomeValue(10);
        SomeValue value2 = new SomeValue(20);
        map.put(key, value1);
        map.put(key,  value2);
        System.out.println("map.get(key) = " + map.get(key));


        Map<SomeKeyWithFixedHash, SomeValue> map2 = new HashMap<>();
        SomeKeyWithFixedHash key1 = new SomeKeyWithFixedHash(2, 3);
        SomeKeyWithFixedHash key2 = new SomeKeyWithFixedHash(3, 3);
        SomeValue valueTen = new SomeValue(10);
        SomeValue valueTwenty = new SomeValue(20);
        map2.put(key1, valueTen);
        map2.put(key2, valueTwenty);
        System.out.println("map2.get(key1) = " + map2.get(key1));
        System.out.println("map2.get(key2) = " + map2.get(key2));
    }

    private record SomeKey(int key) {}
    private record SomeValue(int value) {}

    private record SomeKeyWithFixedHash(int key, int hash) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SomeKeyWithFixedHash that = (SomeKeyWithFixedHash) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }


}
