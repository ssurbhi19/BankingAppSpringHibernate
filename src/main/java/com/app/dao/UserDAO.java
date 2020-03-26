package com.app.dao;

import com.app.model.User;
import java.util.List;

public interface UserDAO
{
    public void save(User user, int branchId);
    public List<User> getAll();
    public void deleteUser(User user);
    public void updateUser(User user);
    public float debit(int amount,int userId);
    public float credit(int amount,int userId);
}
