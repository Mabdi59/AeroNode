package com.aviation.management.dao;

import com.aviation.management.model.RegisterUserDto;
import com.aviation.management.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
