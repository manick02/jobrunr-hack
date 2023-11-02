package org.example;

import java.time.Duration;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

public class SystemClockSimulation {
    public static void main(String[] args) {
      SystemClockSimulation systemClockSimulation = new SystemClockSimulation();
      Clock clock = systemClockSimulation.getTime();
      Clock clock1 = Clock.systemUTC();
      Duration futureOffset = Duration.ofMinutes(2);
      Duration pastOffset = Duration.ofMinutes(-2);
      Clock future = Clock.offset(clock1, futureOffset);
        Clock past = Clock.offset(clock1, pastOffset);
        System.out.println(clock.instant());
       System.out.println(future.instant());
        System.out.println(past.instant());
//        LocalDateTime now1 = LocalDateTime.now(clock);
//        System.out.println(now1.toString());
//        LocalDateTime now = LocalDateTime.now();
//      System.out.println(now);

    }
    private SystemClockSimulation() {

    }
    public Clock getTime() {
        Clock clock = Clock.systemUTC();
        return clock;
    }
}
