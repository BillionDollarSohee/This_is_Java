package org.basic.team1.bank;

import java.io.IOException;

public class BankMain {
    public static void main(String[] args) throws IOException {

        Bank bank = new Bank();
        bank.addAccount("02","국민은행");
        bank.getAccount("국민은행");

        Account account = new Account("04","농협은행");
        account.deposit(200000L);
        account.getBalance();
        account.deposit(10000L);
        account.withdraw(5000L);
        System.out.println(account.getBalance());
        System.out.println("                 ==  거래 내역 확인 ==");
        account.getTransactions();

    }
}
