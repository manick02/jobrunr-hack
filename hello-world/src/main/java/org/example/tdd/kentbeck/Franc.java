package org.example.tdd.kentbeck;

public class Franc extends Money {
    protected Franc(int moneyValue) {
        super(moneyValue);
    }

    public Franc multiply(int by) {
        return new Franc(this.moneyValue * by);
    }

}
