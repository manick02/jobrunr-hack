package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowRatelimiterTest {

    @Test
    public void slidingWindowRateLimiterInstantCreation() {
        int windowLimitInSec = 1;
        int windowLimitCount = 2;

        SlidingWindowRatelimiter slidingWindowRatelimiter = new SlidingWindowRatelimiter(windowLimitInSec,windowLimitCount);
        assertNotNull(slidingWindowRatelimiter);
    }

    @Test
    public void slidingWindowWithinLimit() {
        int windowLimitInSec = 1;
        int windowLimitCount = 2;
        SlidingWindowRatelimiter slidingWindowRatelimiter = new SlidingWindowRatelimiter(windowLimitInSec,windowLimitCount);
        boolean allowed = slidingWindowRatelimiter.isAllowed();
        Assertions.assertTrue(allowed);
    }

    @Test
    public void slidingWindowAboveLimit() {
        int windowLimitInSec = 100;
        int windowLimitCount = 1;
        SlidingWindowRatelimiter slidingWindowRatelimiter = new SlidingWindowRatelimiter(windowLimitInSec,windowLimitCount);
        boolean allowed = slidingWindowRatelimiter.isAllowed();
        Assertions.assertTrue(allowed);
        allowed = slidingWindowRatelimiter.isAllowed();
        Assertions.assertFalse(allowed);
    }
}