package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

public class InterfacesFunctionalesTest {
    @Test
    void test() {
        MyClass clazz = new MyClass();
        clazz.metodo(new MyInterfaz() {
            @Override
            public void metodo() {
                System.out.println("Hola");
            }
        });
    }

    private interface MyInterfaz {
        void metodo();
    }

    private class MyClass {
        public void metodo(MyInterfaz myInterfaz) {
            myInterfaz.metodo();
        }
    }
}
