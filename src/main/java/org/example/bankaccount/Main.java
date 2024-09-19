package org.example.bankaccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setBalance(8_000);
        int balance = account.getBalance();
        account.print();
    }
}
