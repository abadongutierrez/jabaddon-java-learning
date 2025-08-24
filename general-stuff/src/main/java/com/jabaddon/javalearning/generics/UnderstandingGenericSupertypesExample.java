package com.jabaddon.javalearning.generics;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class UnderstandingGenericSupertypesExample {
    public static void main(String[] args) {
        List<IOException> list = new ArrayList<>();
        list.add(new IOException());
        list.add(new EOFException());
        list.add(new RemoteException());
        list.add(new AccessException(""));
        list.add(new ConnectException(""));

        var exception = new Exception();
        var throwable = new Throwable();
        List<? super IOException> listWithSuper = new ArrayList<>();
//        listWithSuper.add(exception);
//        listWithSuper.add(throwable);
//        listWithSuper.add(new Object());
        listWithSuper.add(new IOException());
        listWithSuper.add(new EOFException());
        listWithSuper.add(new RemoteException());
        listWithSuper.add(new FileNotFoundException());
        listWithSuper.add(new AccessException(""));

        List<? extends IOException> listWithExtends = new ArrayList<>();
//        listWithExtends.add(new IOException());
//        listWithExtends.add(new EOFException());
//        listWithExtends.add(new RemoteException());

        List<? extends IOException> listWithExtends2 = List.of(new IOException(), new EOFException(), new RemoteException(), new AccessException(""), new ConnectException(""));
    }
}
