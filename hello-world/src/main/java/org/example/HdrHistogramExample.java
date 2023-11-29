package org.example;

import org.HdrHistogram.Histogram;

// https://github.com/HdrHistogram/HdrHistogram/blob/master/src/main/java/org/HdrHistogram/Histogram.java#L44
public class HdrHistogramExample {

    public static void main(String[] args) throws InterruptedException {
        Histogram histogram = new Histogram(5);
        histogram.recordValue(1000000);
        histogram.recordValue(1000001);
        histogram.recordValue(1000002);
        histogram.recordValue(90);
        histogram.recordValue(10);

        System.out.println(histogram.getValueAtPercentile(50.0));
        System.out.println(histogram.lowestEquivalentValue(1000003));
        System.out.println(histogram.highestEquivalentValue(1000003));
        System.out.println(histogram.highestEquivalentValue(90));
        System.out.println(histogram.highestEquivalentValue(90));
        System.out.println(histogram.getValueAtPercentile(90));
        System.out.println(histogram.getValueAtPercentile(10));
        System.out.println(histogram.getValueAtPercentile(100));
    }
}
