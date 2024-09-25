package com.solvd.laba.jjaccomando;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import static org.mockito.Mockito.*;

public class MyConnectionPool {

    private static MyConnectionPool instance;
    private final BlockingQueue<Connection> pool;
    private static final int POOL_SIZE = 5;

    private MyConnectionPool() {
        pool = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.add(new Connection());
        }
    }

    public static synchronized MyConnectionPool getInstance() {
        if (instance == null) {
            instance = new MyConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    public boolean releaseConnection(Connection connection) {
        return pool.offer(connection);
    }
}


