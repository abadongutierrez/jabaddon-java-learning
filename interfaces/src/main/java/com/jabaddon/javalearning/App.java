package com.jabaddon.javalearning;

public class App implements Interface1, Interface2 {

    public static void main(String[] args) {
        Interface2 app = new App();
        System.out.println(app.method());
    }

    @Override
    public String method() {
        return "Hola!";
    }
}
