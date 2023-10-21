package org.example;

/**
 * Understanding by implementing binary polynomial division which is used in CheckSum
 * Referred - https://www.geeksforgeeks.org/modulo-2-binary-division/ to understand binary polynomial division
 * Reference - https://www.amazon.in/Hackers-Delight-Henry-Warren-Jr/dp/0201914654
 */
public class BinaryPolynomial {

    public static void main(String[] args) {
        System.out.println( extractLSB(100));
        System.out.println( extractLSB(131));
        System.out.println(extractLastNBit(100,2));
        System.out.println(Integer.toBinaryString(extractLastNBit(0xFF,3)));
        System.out.println(Integer.toBinaryString(extractNthBit(0xFF,3)));
    }

    public static void multiply(int a, int b ) {

    }


    public static int extractLSB(int b) {
        return b & 0x1;
    }

    public static int extractLastNBit(int b, int N) {

        return (b & ((1 << N) - 1));
    }

    public static int extractNthBit(int b, int N) {
        return (b & ((0x1) << (N-1)))>>(N-1);
    }



}
