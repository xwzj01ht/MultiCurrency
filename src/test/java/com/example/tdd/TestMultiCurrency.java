package com.example.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

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

    // Dollar类有副作用吗？
    @Test
    public void testMultiplication() {
        /*Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);*/

        // 将 amount 定义为私有
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }

    // 实现equals()函数，使得Dollar成为数值对象
    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
    }

    // 5瑞士法郎*2=10瑞士法郎
    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}
