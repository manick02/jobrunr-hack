package org.example;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;

public class CodaHaleMetricsHack {

    public static void main(String[] args) {
       testCounter();
       testMeter();
    }

    private static void testCounter() {
        Counter counter = new Counter();
        counter.inc();
        counter.inc();
        counter.inc();
        counter.dec();
        System.out.println(counter.getCount());
    }

    private static void testMeter() {
        Meter meter = new Meter();
        meter.mark();
        meter.mark(10);
        System.out.println(meter.getOneMinuteRate());
        meter.mark(10);
        System.out.println(meter.getOneMinuteRate());
        meter.mark(10);
        System.out.println(meter.getOneMinuteRate());
        System.out.println(meter.getCount());
        System.out.println(meter.getMeanRate());
    }


}
