package com.app.dao;

import com.app.model.Bank;
import com.app.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void save(Bank bank)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(bank);
        tx.commit();
    }

    @Override
    public void deleteBranch(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(bank);
        tx.commit();
    }

    @Override
    public void updateBranch(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(bank);
        tx.commit();
    }

    @Override
    public void saveBranchUSer(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(bank);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Bank> getAll()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Bank> personList = session.createQuery("from Bank").list();
        return personList;
    }

}
