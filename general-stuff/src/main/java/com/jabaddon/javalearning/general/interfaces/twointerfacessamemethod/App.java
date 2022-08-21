package com.jabaddon.javalearning.general.interfaces.twointerfacessamemethod;

public class App implements InterfaceOne, InterfaceTwo{
    @Override
    public String sayHello() {
        return "Hello!";
    }

    public static void main(String[] args) {
        InterfaceTwo app = new App();
        System.out.println(app.sayHello());
    }
}
