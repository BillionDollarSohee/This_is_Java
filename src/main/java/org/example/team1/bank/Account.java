package org.example.team1.bank;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class Account {
    @Getter
    private String accountNo; // 계좌번호
    @Getter
    private String name; // 소유자명
    private Long balance; // 잔고
    private List<Transaction> transactions; //거래내역 0개 이상

    Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0L;
        this.transactions = new ArrayList<>();
    }

    public void deposit(Long inputMoney) {
        System.out.println(inputMoney + "원 입금하셨습니다.");
        balance += inputMoney;
        Transaction transaction = new Transaction("입금",inputMoney, balance);
        transactions.add(transaction);
        System.out.println("현재 잔액은 " + balance + "원 입니다.");
    }

    public void withdraw(Long outputMoney) {
        if(this.balance<outputMoney) System.out.println("잔액이 부족합니다.");
        else {
            this.balance -= outputMoney;
            System.out.printf("%d원 인출하셨습니다.\n", outputMoney);
            transactions.add(new Transaction("출금", outputMoney, this.balance)); //거래내역 추가
        }
        System.out.printf("현재 잔액은 %d원 입니다.\n", this.balance);
    }

    public Long getBalance() {
        System.out.printf("계좌번호 : " + accountNo + ", 소유자 명 : " + name + " 잔액 : ");
        return balance;
    }

    // 기현님의 거래내역 확인
    public List<Transaction> getTransactions() {
        for(Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
        return this.transactions;
    }




}
