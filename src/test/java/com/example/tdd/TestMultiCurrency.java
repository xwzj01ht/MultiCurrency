package com.example.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMultiCurrency {

    // 5美元*2=10美元
   /* @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
        five.times(3);
        assertEquals(15, five.amount);
    }*/

    //TODO Dollar类有副作用吗？
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }

}
