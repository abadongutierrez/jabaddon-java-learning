package com.jabaddon.javalearning.general;

import java.io.Closeable;
import java.io.IOException;

public class TryWithResourcesExample {

    private static class MyResource implements Closeable {
        public void open() {
            System.out.println("Opening MyResource ...");
        }

        public void doSomething() {
            System.out.println("Doing something with MyResource ...");
        }

        public void doSomethingWithError() {
            System.out.println("Doing something with MyResource ... oops! there is an error!");
            throw new RuntimeException("Some error!");
        }
        
        @Override
        public void close() throws IOException {
            System.out.println("Closing MyResource ... ");
        }
    }

    private static MyResource openResource() {
        MyResource resource = new MyResource();
        resource.open();
        return resource;
    }

    public static void main(String[] args) {
        try(var resource = openResource()) {
           resource.doSomething();
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } finally {

        }

        try(var resource = openResource()) {
            resource.doSomethingWithError();
        } catch (Exception e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } finally {

        }
    }

}
