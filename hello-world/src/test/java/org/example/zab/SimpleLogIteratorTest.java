package org.example.zab;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SimpleLogIteratorTest {
    @Test
    public void iterateSimpleLogs(){
        SimpleLog simpleLog = new SimpleLog("SimpleIterator.txt");
        appendLogs();

    }

    private void appendLogs(SimpleLog log) {
        try {

            LogData logData = new LogData(Long.MAX_VALUE,"hello world".getBytes(),0);
            log.append(logData);
            log.append(logData);
            log.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
