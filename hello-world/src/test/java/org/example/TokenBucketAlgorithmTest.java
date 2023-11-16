package org.example;

import org.junit.Test;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TokenBucketAlgorithmTest {

    @Test
    public void createTokenBucketAlgorithmTest() {
        int refreshTokens = 10;
        int refreshingRateInSec = 60;
        TokenBucketAlgorithm algorithm = new TokenBucketAlgorithm(refreshTokens,refreshingRateInSec);
        assertNotNull(algorithm);
    }

    @Test
    public void canAllow() {

        int refreshToken = 10;
        int refreshingRateInSec = 60;
        TokenBucketAlgorithm algorithm = new TokenBucketAlgorithm(refreshToken,refreshToken);
        assertTrue(algorithm.canAllow());
    }


}
