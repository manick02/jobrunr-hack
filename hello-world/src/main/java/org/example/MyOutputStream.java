package org.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


// Came across this Output combiner class https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
// Also referred apache iot db code base
public class MyOutputStream extends OutputStream {
    List<OutputStream> listOfStreams;
    @Override
    public void write(int b) throws IOException {
        for (OutputStream outputStream: listOfStreams) {
            outputStream.write(b);
        }
    }

    public MyOutputStream(List<OutputStream> listOfStreams) {
        this.listOfStreams = listOfStreams;
    }

    public void close() throws IOException {
        for (OutputStream os : listOfStreams) {
            os.close();
        }

    }

    public void flush() throws IOException {
        for (OutputStream os : listOfStreams) {
            os.close();
        }
    }

   public static void main(String[] args) throws IOException {
       PrintStream out = System.out;
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       OutputStream outputStream = new MyOutputStream(Arrays.asList(out, byteArrayOutputStream));
       System.setOut(new PrintStream(outputStream));
       System.out.println("Hello How are you");

       System.setOut(out);
       String string = byteArrayOutputStream.toString();

       System.out.println("From byte array output stream" + string);
       outputStream.close();
       outputStream.flush();
   }


}
