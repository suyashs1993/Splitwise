package entity;

import java.math.BigDecimal;

public class Balance {

    User payer;
    User receiver;
    BigDecimal amount;

    Expense expense;

    public Balance(User payer, User receiver, BigDecimal amount, Expense expense) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
        this.expense = expense;
    }

    public User getPayer() {
        return payer;
    }

    public User getReceiver() {
        return receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String toString(){
        return receiver.getName() + " owes " + payer.getName() + " Rs " + amount;
    }
}
