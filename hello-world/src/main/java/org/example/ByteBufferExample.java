package org.example;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class ByteBufferExample {

    public static void main(String[] args) {
        byte[] helloWorld = "Hello world".getBytes();

        ByteBuffer byteBuffer = ByteBuffer.wrap(helloWorld);
      //  byteBuffer.flip();
        System.out.println(helloWorld.length);
     //    System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.hasRemaining());
        int limit = byteBuffer.limit();
        System.out.println(limit);
        byteBuffer.mark();
        for(int i = 0; i < limit; i++) {
            System.out.println(byteBuffer.get());
        }
        System.out.println(byteBuffer.hasRemaining());
        System.out.println("----------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.hasRemaining());
        for (int j = 0; j < limit; j++ ) {
            System.out.println(byteBuffer.get());
        }
        System.out.println(byteBuffer.hasRemaining());
        byteBuffer.rewind();
        System.out.println(byteBuffer.hasRemaining());
    }
}
