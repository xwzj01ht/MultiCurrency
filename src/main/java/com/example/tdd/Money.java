package com.example.tdd;

public class Money implements Expression {

    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money)object;
        return amount == money.amount && currency().equals(money.currency());
    }

    String currency() {
        return currency;
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
//        return this;
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
