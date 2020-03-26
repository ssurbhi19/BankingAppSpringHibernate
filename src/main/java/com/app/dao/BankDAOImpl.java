package com.app.dao;

import com.app.model.Bank;
import com.app.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BankDAOImpl implements BankDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Bank bank)
    {
        Session session = this.sessionFactory.openSession();
        session.persist(bank);
    }

    @Override
    @Transactional
    public void deleteBranch(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        session.delete(bank);
    }

    @Override
    @Transactional
    public void updateBranch(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        session.update(bank);
    }

    @Override
    @Transactional
    public void saveBranchUSer(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        session.save(bank);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Bank> getAll()
    {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Bank").list();
    }

}
