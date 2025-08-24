package com.jabaddon.javalearning.general.exceptions.catchorder;

public class ExceptionHandling
{
    public static void main(String[] args) {
        try {
            System.out.println(Integer.parseInt("43"));
        }
        catch(Exception ex) {
            System.out.println("Exception!");
        }
        // Compile error => java: exception java.lang.NumberFormatException has already been caught
//        catch(NumberFormatException ex) {
//            System.out.println("NumberFormatException!");
//        }
    }
}
