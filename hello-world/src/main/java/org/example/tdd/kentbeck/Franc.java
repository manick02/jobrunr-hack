package org.example.tdd.kentbeck;

public class Franc {
    private int moneyValue;
    public Franc(int moneyValue) {
        this.moneyValue = moneyValue;
    }

    public Franc multiply(int by) {
        return new Franc(this.moneyValue * by);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franc dollar = (Franc) o;
        return moneyValue == dollar.moneyValue;
    }

}
