package org.example.tdd.kentbeck;

import org.junit.Test;

import static org.junit.Assert.*;

public class DollarTest {

    @Test
    public void multiplyDollar(){
        Dollar dollar = new Dollar(4);
        Dollar multiply = dollar.multiply(5);
        assertTrue(new Dollar(20).equals(multiply));
    }

    @Test
    public void multiplyDollarNotEqual() {
        Dollar dollar = new Dollar(4);
        Dollar multiply = dollar.multiply(5);
        assertFalse(new Dollar(19).equals(multiply));
    }
}
