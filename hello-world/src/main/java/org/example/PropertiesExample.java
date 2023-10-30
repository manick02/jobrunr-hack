package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream =ClassLoader.getSystemClassLoader().getResourceAsStream("conf.properties"); InputStreamReader inputStreamReader = new InputStreamReader(inputStream,StandardCharsets.UTF_8); BufferedReader br = new BufferedReader(inputStreamReader);) {
            properties.load(br); //  new FileInputStream("conf.properties")
            System.out.println(properties.getProperty("raft.server.address.list"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
