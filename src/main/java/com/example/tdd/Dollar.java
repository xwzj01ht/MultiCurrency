package com.example.tdd;

import java.util.Objects;

public class Dollar extends Money {

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
