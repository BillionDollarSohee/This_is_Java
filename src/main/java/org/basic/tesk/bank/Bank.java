package org.basic.tesk.bank;

import java.util.ArrayList;
import java.util.List;


public class Bank {
    List<Account> accounts; //계좌
    int totalAccount; //총 계좌수

    Bank () {
        this.accounts = new ArrayList<>();
        this.totalAccount = accounts.size();
    }

    public void addAccount(String accountNo, String name) {
        accounts.add(new Account(accountNo,name));
    }

    public void getAccount(String accountNo) {
        for (Account a : accounts) {
            if (a.getAccountNo().equals(accountNo)) {
                for (Transaction t : a.getTransactions()) {
                    System.out.println(t.toString());
                }
                break;
            }
        }
    }

    public List<Account> findAccounts() {
        return null;
    }

    public List<Account> getAccounts() {
        return null;
    }

    public int getTotalAccount() {
        return 0;
    }
}
