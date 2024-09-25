package com.solvd.laba.jjaccomando;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

public class Executor {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExtendingThreadClass(), "Thread 1");
        Thread thread2 = new Thread(new ImplementsRunnableClass(), "Thread 2");

        thread1.start();
        thread2.start();

        MyConnectionPool pool = MyConnectionPool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = pool.getConnection();
                    System.out.println("Got connection: " + Thread.currentThread().getName());
                    Thread.sleep(2000); // Simulate work with connection
                    if(pool.releaseConnection(connection))
                        System.out.println("Released connection: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executor);
        }

        executor.shutdown();
    }
}
