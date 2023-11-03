package org.example.tdd.kentbeck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DollarTest {

    @Test
    public void multiplyDollar(){
        Dollar dollar = new Dollar(4);
        Dollar multiply = dollar.multiply(5);
        assertTrue(new Dollar(20).equals(multiply));
    }
}
