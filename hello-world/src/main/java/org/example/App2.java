package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class App2 {

    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("Hello.txt");
             BufferedWriter bw = new BufferedWriter(fw);)
        {
            bw.write("Hello - this is test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
