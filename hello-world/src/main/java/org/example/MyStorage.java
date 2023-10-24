package org.example;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyStorage extends OutputStream {
    private final BufferedOutputStream bufferedOutputStream;
    private final FileOutputStream wrappingOutStream;
    private  static final int defaultBufferSize = 1024;

    private int currentPosition;

    public MyStorage(FileOutputStream stream) {
        this(stream, defaultBufferSize);
    }

    public MyStorage(FileOutputStream stream, int bufferSize) {
        this.wrappingOutStream = stream;
        this.bufferedOutputStream = new BufferedOutputStream(stream, bufferSize);
        this.currentPosition = 0;
    }

    @Override
    public synchronized void write(int b) throws IOException {
        this.bufferedOutputStream.write(b);
        this.currentPosition += 1;
    }

    @Override
    public synchronized void write(byte[] buf, int start, int offset) throws IOException {
        this.bufferedOutputStream.write(buf, start, offset);
        this.currentPosition += offset;
    }

    @Override
    public synchronized void write(byte[] b) throws IOException {
        this.bufferedOutputStream.write(b);
        this.currentPosition += b.length;
    }
    @Override
    public void flush() throws IOException {
        this.bufferedOutputStream.flush();
    }


    public void close() throws IOException {
        this.bufferedOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        try (MyStorage myStorage = new MyStorage(new FileOutputStream("test.01"))) {
            myStorage.write("Hello World".getBytes());
        }

        try (BufferedOutputStream myStorage = new BufferedOutputStream(new FileOutputStream("test.02"))) {
            myStorage.write("Hello word using default implementation".getBytes());
        }
    }

}
