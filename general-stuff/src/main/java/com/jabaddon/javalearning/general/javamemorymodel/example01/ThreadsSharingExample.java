/*-
 * =====LICENSE-START=====
 * Java Application
 * ------
 * Copyright (C) 2020 - 2024 Organization Name
 * ------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====LICENSE-END=====
 */
package com.jabaddon.javalearning.general.javamemorymodel.example01;

public class ThreadsSharingExample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable1 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable1, "Thread 2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("At the end, Count is " + runnable1.getCount());
    }
}
