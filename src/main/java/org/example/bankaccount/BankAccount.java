package org.example.bankaccount;

public class BankAccount implements Printable {
    private String account;
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public void print() {
        System.out.println("Balance account: " + this.balance);
    }
}
