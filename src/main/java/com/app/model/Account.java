package com.app.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private int accountId;

    @Column(name="account_no")
    private String account_no;

    @Column(name="balance")
    private float balance;

    public Account() {
    }

    public Account(String account_no, float balance) {
        this.account_no = account_no;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", account_no='" + account_no + '\'' +
                ", balance=" + balance +
                '}';
    }
}
