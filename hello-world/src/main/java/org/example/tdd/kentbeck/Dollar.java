package org.example.tdd.kentbeck;

import java.util.Objects;

public class Dollar {
    private int moneyValue;
    public Dollar(int moneyValue) {
        this.moneyValue = moneyValue;
    }

    public Dollar multiply(int by) {
        return new Dollar(this.moneyValue * by);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollar dollar = (Dollar) o;
        return moneyValue == dollar.moneyValue;
    }

}
