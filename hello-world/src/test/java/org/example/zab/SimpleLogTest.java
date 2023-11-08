package org.example.zab;

import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleLogTest {

    @Test
    public void simpleLogCreation() {
        SimpleLog log = new SimpleLog(new File("simple.log"));
        assertTrue(log!=null);
    }
}
