package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.time.Clock;
import java.time.Instant;

public class TokenBucketAlgorithm {

    private final int refreshTokenRateInSeconds;
    private final int refreshToken;

    private Instant lastRefreshInstant = null;

    private int currentCount;

    public TokenBucketAlgorithm(int refreshToken, int refreshTokenRateInSeconds) {
        this.refreshToken = refreshToken;
        this.refreshTokenRateInSeconds = refreshTokenRateInSeconds;
    }

    public boolean canAllow() {
        Instant currentInstant = Clock.systemUTC().instant();
        if (lastRefreshInstant == null) {
            lastRefreshInstant = currentInstant;
            currentCount = this.refreshToken;
        } else if (currentInstant.compareTo(lastRefreshInstant) > refreshTokenRateInSeconds) {

        }
        if (this.currentCount > 0) {
            this.currentCount--;
            return true;
        }

        return false;
    }
}
