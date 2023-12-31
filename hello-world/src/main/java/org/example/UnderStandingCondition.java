package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnderStandingCondition {
    static BoundedCounter boundedCounter = new BoundedCounter(5);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        int simulateFor = 1000;
        Thread incrementThread = Thread.ofVirtual().start(() -> {
            int inc = 0;
            while (inc < simulateFor) {
                boundedCounter.increment();
                inc++;
            }
            latch.countDown();
        });
    //    boundedCounter.decrement();

        Thread decrementThread = Thread.ofVirtual().start(() -> {
            int dec = 0;
            while( dec < simulateFor) {
                boundedCounter.decrement();
                dec++;
            }
            latch.countDown();
        });

        // boundedCounter.increment(); // simulating wait..lets see what happens
        latch.await();
    }

    static class BoundedCounter {
        private final int bound;
        private final Condition notLowerBound;
        int count = 0;

        private Lock lock;

        private final Condition notUpperBound;

        BoundedCounter(int limit) {
            this.bound = limit;
            this.lock = new ReentrantLock();
            this.notUpperBound = this.lock.newCondition();
            this.notLowerBound = this.lock.newCondition();
        }

        public void increment() {
            lock.lock();
            try {
                while (this.count == this.bound) {
                    System.out.println("Await -- increment");
                    notUpperBound.await();
                    System.out.println("Woken up -- increment");
                }
                this.count++;
                System.out.println(this.count);
                this.notLowerBound.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

        public void decrement() {
            lock.lock();
            try {
                while (this.count == 0) {
                    System.out.println("Await -- decrement");
                    notLowerBound.await();
                    System.out.println("Woken Up -- decrement");
                }
                this.count--;
                System.out.println(this.count);
                this.notUpperBound.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
