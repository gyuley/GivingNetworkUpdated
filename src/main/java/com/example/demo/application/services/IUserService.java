package com.example.demo.application.services;

import com.example.demo.application.entities.User;
import java.util.List;

public interface IUserService {

    public void save(User user);
    public List<User> getUsers();
    public void deleteUser(User user);
    public void editUser(User user);
}