package org.example.team1.bank;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Transaction {
    private String transactionTime;
    private String transactionDate;
    String kind; //구분
    Long amount; // 거래 금액
    Long balance; //잔고

    Transaction(String kind, Long amount, Long balance) {
        this.transactionTime =  new SimpleDateFormat("HH시MM분SS초").format(new Date());
        this.transactionDate = new SimpleDateFormat("yyyy년MM월dd일").format(new Date());
        this.kind = kind;
        this.amount = amount; // 거래 금액
        this.balance = balance; //잔고
    }

    @Override
    public String toString() {
        return "[ 거래금액:" + amount +
                ", 잔액:" + balance + "원 /" +
                transactionDate +" "+ transactionTime + " ]";
    }

}
