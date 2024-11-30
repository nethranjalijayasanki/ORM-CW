package com.example.ormcw.dao.custom;

import com.example.ormcw.dao.CrudDAO;
import com.example.ormcw.entity.User;

public interface UserDAO extends CrudDAO<User> {
    public boolean update(User entity, String firstUserName);
    User searchByName(String userNameText);

    public void initializeDefaultUser();

    boolean updatePassword(String newPassword, String userName);
}
