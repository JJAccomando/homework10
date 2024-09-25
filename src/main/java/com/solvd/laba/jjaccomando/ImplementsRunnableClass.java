package com.solvd.laba.jjaccomando;

import static java.lang.System.out;

public class ImplementsRunnableClass implements Runnable {

    public void run() {
        out.println("Thread is running: " + Thread.currentThread().getName());
    }
}
