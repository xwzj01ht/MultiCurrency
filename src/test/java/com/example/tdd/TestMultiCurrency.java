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
        /*Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));*/

        // 美元Dollar/瑞士法郎Franc之间的重复设计
        /*Money five = Money.dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));*/

        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    // 实现equals()函数，使得Dollar成为数值对象
    @Test
    public void testEquality() {

//        assertTrue(new Dollar(5).equals(new Dollar(5)));
//        assertFalse(new Dollar(5).equals(new Dollar(6)));

        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));

//        assertTrue(new Franc(5).equals(new Franc(5)));
//        assertFalse(new Franc(5).equals(new Franc(6)));

        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));

        // 比较法郎对象和美元对象
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    // 5瑞士法郎*2=10瑞士法郎
//    @Test
//    public void testFrancMultiplication() {
//        Money five = Money.franc(5);
//        assertEquals(Money.franc(10), five.times(2));
//        assertEquals(Money.franc(15), five.times(3));
//    }

    // 货币？
    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    // 5美元+5美元=10美元
//    @Test
//    public void testSimpleAddition() {
//        Money sum = Money.dollar(5).plus(Money.dollar(5));
//        assertEquals(Money.dollar(10), sum);
//    }

    @Test
    public void testReductionAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Sum sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), reduced);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money reduced = bank.reduce(Money.dollar(7), "USD");
        assertEquals(Money.dollar(7), reduced);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        // 我有2法郎，但想得到1美元
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testArrayEquals() {
        assertEquals(new Object[]{"abc"}, new Object[]{"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    // 当瑞士法郎与美元的兑换率为2:1的时候，5美元+10瑞士法郎=10美元
    @Test
    public void testMixedAdditionMoney() {
        Money fiveBucks = Money.dollar(5);
        Money tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testMixedAdditionExpression() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

}
