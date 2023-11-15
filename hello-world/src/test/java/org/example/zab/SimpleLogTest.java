package org.example.zab;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleLogTest {

    @Test
    public void simpleLogCreation() {

        SimpleLog log = null;
        try {
            log = new SimpleLog(new File("simple.log"));
            log.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(log!=null);
    }

    @Test
    public void appendLog(){

        try {
            SimpleLog log = new SimpleLog(new File("simple.log"));
            LogData logData = new LogData(Long.MAX_VALUE,"hello world".getBytes(),0);
            log.append(logData);
            log.append(logData);
            log.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path path = Paths.get("simple.log");
        assertTrue(Files.exists(path));
    }
}
