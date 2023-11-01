package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is one of the pattern that is used in IoT db
 */
public class AutoCloseableLock implements AutoCloseable{
    private final Lock delegete;

    public  static AutoCloseableLock acquire(Lock lock) {

        return new AutoCloseableLock(lock);
    }

    public AutoCloseableLock(Lock lock) {
        this.delegete = lock;
        this.delegete.lock();
    }


    @Override
    public void close() throws Exception {
        System.out.println("Lock has been unlocked");
        this.delegete.unlock();
    }


    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        try(AutoCloseableLock autoCloseableLock = new AutoCloseableLock(lock)){
            System.out.println("Hello = ");
        }
    }
}
