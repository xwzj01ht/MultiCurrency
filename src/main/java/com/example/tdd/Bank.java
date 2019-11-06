package com.example.tdd;

public class Bank {

    Money reduce(Expression source, String to) {
////        return Money.dollar(10);
//        if (source instanceof Money)
//            return (Money) source;
//        Sum sum = (Sum) source;
////        int amount = sum.augend.amount + sum.addend.amount;
//        return sum.reduce(to);
        return source.reduce(to);
    }

}
