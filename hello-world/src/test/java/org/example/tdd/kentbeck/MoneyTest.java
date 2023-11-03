package org.example.tdd.kentbeck;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void multiplyDollar(){
        Dollar dollar = Money.dollar(4);
        Dollar multiply = dollar.multiply(5);
        assertTrue(new Dollar(20).equals(multiply));
    }

    @Test
    public void multiplyDollarNotEqual() {
        Dollar dollar =  Money.dollar(4);
        Dollar multiply = dollar.multiply(5);
        assertFalse(new Dollar(19).equals(multiply));
    }

    @Test
    public void multiplyFranc(){
        Franc chf = Money.franc(4);
        Franc multiply = chf.multiply(5);
        assertTrue(new Franc(20).equals(multiply));
    }

    @Test
    public void multiplyFrancNotEqual() {
        Franc chf = Money.franc(4);
        Franc multiply = chf.multiply(5);
        assertFalse(new Franc(19).equals(multiply));
    }
}
