package com.example.tdd;

import java.util.Hashtable;
import java.util.Objects;

public class Bank {

    private Hashtable rates = new Hashtable();

    Money reduce(Expression source, String to) {
////        return Money.dollar(10);
//        if (source instanceof Money)
//            return (Money) source;
//        Sum sum = (Sum) source;
////        int amount = sum.augend.amount + sum.addend.amount;
//        return sum.reduce(to);
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
//        return (from.equals("CHF") && to.equals("USD"))
//                ? 2
//                : 1;
        if (from.equals(to)) return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }

    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }

    private class Pair {

        private String from;
        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return from.equals(pair.from) &&
                    to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

}
