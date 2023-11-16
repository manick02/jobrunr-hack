package org.example;

import java.time.Clock;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRatelimiter {
    private final int windowSizeInSec;
    private final int windowLimit;

    private final Queue<Instant> request;
    public SlidingWindowRatelimiter(int windowSizeInSec, int windowLimit) {
        this.windowSizeInSec = windowSizeInSec;
        this.windowLimit = windowLimit;
        this.request = new LinkedList<>();
    }

    public synchronized boolean isAllowed() {
        Instant instant = Clock.systemUTC().instant();
        purgeExpiredTokens(instant);
        if (request.size() < windowLimit) {
            request.add(instant);
            return true;
        }
        return false;
    }

    private void purgeExpiredTokens(Instant current) {

        while(!request.isEmpty()) {
            Instant peek = request.peek();
            long diff = current.getEpochSecond() - peek.getEpochSecond();
            if (diff>windowSizeInSec) {
                request.remove();
            } else {
                break;
            }
        }
    }
}
