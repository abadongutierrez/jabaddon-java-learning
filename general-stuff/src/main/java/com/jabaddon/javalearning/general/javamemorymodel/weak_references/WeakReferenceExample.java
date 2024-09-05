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
package com.jabaddon.javalearning.general.javamemorymodel.weak_references;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        WeakReference<MyObject> weakRef = new WeakReference<>(obj);

        // Clearing strong reference
        obj = null; // At this point, MyObject is only referenced by weakRef

        // Suggesting garbage collection
        System.gc(); // MyObject may be collected
        MyObject retrieved = weakRef.get(); // Will return null if collected
        if (retrieved == null) {
            System.out.println("MyObject has been garbage collected.");
        } else {
            System.out.println("MyObject is still alive.");
        }
    }
}
