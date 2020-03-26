package com.app.dao;

import com.app.model.Account;
import com.app.model.Bank;
import com.app.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;
import java.util.Random;

@Repository
public class UserDAOImpl implements UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(User user, int branchId)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Bank bank = session.get(Bank.class,branchId);
        int branchCode = bank.getBranchCode();
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        String accNumber=branchCode+id;
        Account account=new Account(accNumber,0.0f);
        user.setAccount(account);
        user.setBank(bank);
        session.save(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> personList = session.createQuery("from User").list();
        return personList;
    }

    public void deleteUser(User user)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
    }

    public void updateUser(User user)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
    }

    @Transactional
    public float credit(int amount,int userId)
    {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,userId);
        float currentBalance= user.getAccount().getBalance();
        user.getAccount().setBalance(currentBalance+amount);
        session.update(user);
        return currentBalance+amount;
    }

    @Transactional
    public float debit(int amount,int userId)
    {
        Session session = sessionFactory.getCurrentSession();
        User user=session.get(User.class, userId);

        float currentBalance = user.getAccount().getBalance();

        float updatedBc= currentBalance-amount;
        if(updatedBc<0)
        {
            return -1;
        }
        else {
            user.getAccount().setBalance(updatedBc);
            session.update(user);
        }
        return updatedBc;
    }

}
