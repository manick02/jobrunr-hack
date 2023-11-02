package org.example;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HearbeatScheduler {
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
    private final Runnable runnable;
    ScheduledFuture<?> scheduledFuture;
    long delaySec;
    private boolean initialised = false;
    public HearbeatScheduler(Runnable runnable, long delaySec) {
       this.runnable = runnable;
       this.delaySec = delaySec;
    }

    public synchronized void start() {
        if(!initialised) {
            scheduledFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(this.runnable,delaySec, delaySec, TimeUnit.SECONDS);
            initialised = true;
        }
    }

    public synchronized void stop() {
        scheduledFuture.cancel(true);
        shutdown();
    }

    private void shutdown() {
        scheduledThreadPoolExecutor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        HearbeatScheduler scheduler = new HearbeatScheduler(()-> System.out.println("Hello i am checking heart beat"),5);
        scheduler.start();
        Thread.sleep(20000);
        scheduler.stop();
        Thread.sleep(15000);
    }
}
