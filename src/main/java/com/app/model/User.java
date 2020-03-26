package com.app.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int userId;

    @Column(name="full_name")
    private String fullName;

    @Column(name="aadhar_no")
    private String aadharNo;

    @Column(name = "given_branch_id")
    private int givenBranchId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "branch_id")
    private Bank bank;

    public User()
    {
    }

    public User(String fullName, String aadharNo, int givenBranchId)
    {
        this.fullName = fullName;
        this.aadharNo = aadharNo;
        this.givenBranchId = givenBranchId;
    }

    public int getGivenBranchId() {
        return givenBranchId;
    }

    public void setGivenBranchId(int givenBranchId) {
        this.givenBranchId = givenBranchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAadharNo()
    {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo)
    {
        this.aadharNo = aadharNo;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", aadharNo='" + aadharNo + '\'' +
                '}';
    }
}


