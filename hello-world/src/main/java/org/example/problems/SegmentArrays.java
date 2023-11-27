package org.example.problems;

// https://www.geeksforgeeks.org/divide-array-k-segments-maximize-maximum-segment-minimums/
// Given an array of n integers, divide it into k segments and find the maximum of the minimums of k segments. Output the maximum integer that can be obtained among all ways to segment in k subarrays.

import java.util.Arrays;
import java.util.OptionalInt;

public class SegmentArrays {

    public static void main(String[] args){
        System.out.println("Hello");
        int[] segments = new int[] {-5, -1};
        int k =1;
        if (k==1) {
            System.out.println(maxOfMinSegments(segments,k).getAsInt());
        } else if (k==2) {
            System.out.println(Math.min(segments[0],segments[segments.length-1]));
        } else if (k >= 3) {
            System.out.println(segments[segments.length - 1]);
        }
    }

    public static OptionalInt maxOfMinSegments(int[] segments, int k) {
        OptionalInt min = Arrays.stream(segments).min();
        return min;
    }

}
