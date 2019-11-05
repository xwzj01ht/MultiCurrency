package com.example.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMultiCurrency {

    //TODO 5美元*2=10美元
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}
