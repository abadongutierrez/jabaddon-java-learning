package com.jabaddon.resilience4j.test;

import java.util.concurrent.TimeUnit;

public class HelloWorldSlowService implements HelloWorldService {
    @Override
    public String sayHelloWorld() {
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World after some minutes";
    }
}
