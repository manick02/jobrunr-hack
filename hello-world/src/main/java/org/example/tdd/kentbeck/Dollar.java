package org.example.tdd.kentbeck;

import java.util.Objects;

public class Dollar extends Money {
    protected Dollar(int moneyValue) {
      super(moneyValue);
    }

    public Dollar multiply(int by) {
        return new Dollar(this.moneyValue * by);
    }

}
