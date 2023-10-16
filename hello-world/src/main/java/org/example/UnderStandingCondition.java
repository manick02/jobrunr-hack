package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnderStandingCondition {
    static   BoundedCounter boundedCounter = new BoundedCounter(2);

    public static void main(String[] args) throws InterruptedException {
        boundedCounter = new BoundedCounter(1);
        CountDownLatch latch = new CountDownLatch(2);
        Thread incrementThread = Thread.ofPlatform().start(()->{
            int inc = 0;
            while (inc <  11) {
                boundedCounter.increment();
                boundedCounter.decrement();
                inc++;
            }
            latch.countDown();
        });
        Thread decrementThread = Thread.ofPlatform().start(() -> {
            int dec = 0;
            while( dec < 11 ) {
                boundedCounter.decrement();
                boundedCounter.decrement();
                dec++;
            }
            latch.countDown();
        });

        //boundedCounter.increment(); // simulating wait..lets see what happens
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
                while(this.count==this.bound) {
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
                while(this.count==0) {
                    System.out.println("Await -- decrement");
                    notLowerBound.await();
                    System.out.println("Woken Up -- decrement");
                }
                this.count--;
                System.out.println(this.count);
                this.notUpperBound.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }
        }
    }
}
