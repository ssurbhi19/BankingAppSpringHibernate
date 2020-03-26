package com.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank")
public class Bank
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="branch_id")
    private int branchId;

    @Column(name="branch_code")
    private int branchCode;

    @Column(name="branch_name")
    private String branchName;

    @OneToMany(mappedBy = "bank",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<User> users;

    public Bank() {
    }

    public Bank(int branchCode, String branchName)
    {
        this.branchCode = branchCode;
        this.branchName = branchName;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "branchCode=" + branchCode +
                ", branchName='" + branchName + '\'' +
                '}';
    }

    public void add( User user )
    {
        if(users==null)
            users = new ArrayList<User>();

        users.add(user);

    }

}
