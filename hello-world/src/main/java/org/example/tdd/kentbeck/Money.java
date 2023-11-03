package org.example.tdd.kentbeck;

public class Money {
    protected int moneyValue;

    public Money(int moneyValue) {
        this.moneyValue = moneyValue;
    }

    public static Dollar dollar(int i) {
        return new Dollar(i);
    }

    public static Franc franc(int i) {
        return new Franc(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return moneyValue == money.moneyValue;
    }
}
