package com.example.ormcw.bo.custom;

import com.example.ormcw.bo.SuperBO;
import com.example.ormcw.dto.UserDTO;
import com.example.ormcw.entity.User;

import java.util.List;

public interface UserBO extends SuperBO {
    /*public UserDTO getAll(String userNameText);*/


    User searchUserbyName(String userNameText);

    public void intializeDefaultUser();

    boolean saveUser(User userDTO);

    List<UserDTO> getAllUser();

    boolean deleteUser(String userName);

    boolean updateUserPassword(String newpassword, String userName);

    boolean updateUser(User user);
    public boolean updateUser(User user, String firstUserName);

}
