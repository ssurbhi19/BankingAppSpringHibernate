package com.app.dao;

import com.app.model.Bank;
import java.util.List;

public interface BankDAO
{
    public void save(Bank bank);
    public List<Bank> getAll();
    public void deleteBranch(Bank bank);
    public void updateBranch(Bank bank);
    public void saveBranchUSer(Bank bank);
}
