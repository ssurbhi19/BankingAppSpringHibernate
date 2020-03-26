package com.app.controller;

import com.app.dao.BankDAO;
import com.app.model.Bank;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class BankController
{
    @Autowired
    BankDAO bankDAO;

    @PostMapping(value = "/saveBranch")
    public Bank addBranch(@RequestBody Bank bank)
    {
        bankDAO.save(bank);
        return bank;
    }

    @PostMapping(value = "/saveBranchUser")
    public Bank addBranchUser(@RequestBody Bank bank)
    {
        bankDAO.saveBranchUSer(bank);
        return bank;
    }

    @GetMapping(value = "/getBranch" )
    public List<Bank> getBranch()
    {
        return bankDAO.getAll();
    }

    @PostMapping(value="/deleteBranch")
    public Bank removeBranch(@RequestBody Bank bank)
    {
        bankDAO.deleteBranch(bank);
        return bank;
    }

    @RequestMapping(value="/updateBranch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bank update(@RequestBody Bank bank)
    {
        bankDAO.updateBranch(bank);
        return bank;
    }

}


