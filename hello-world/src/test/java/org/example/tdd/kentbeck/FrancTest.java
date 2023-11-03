package org.example.tdd.kentbeck;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrancTest {
    @Test
    public void multiplyFranc(){
        Franc chf = new Franc(4);
        Franc multiply = chf.multiply(5);
        assertTrue(new Franc(20).equals(multiply));
    }

    @Test
    public void multiplyFrancNotEqual() {
        Franc chf = new Franc(4);
        Franc multiply = chf.multiply(5);
        assertFalse(new Franc(19).equals(multiply));
    }
}
