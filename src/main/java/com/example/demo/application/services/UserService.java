package com.example.demo.application.services;

import java.util.List;

import com.example.demo.application.entities.User;
import com.example.demo.application.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private Users users;

    @Override
    public void save(User user) {
        users.save(user);
    }

    @Override
    public List<User> getUsers() {
        return users.getUsers();
    }

    @Override
    public void deleteUser(User user) {
        users.deleteUser(user);
    }

    @Override
    public void editUser(User user) {
        users.editUser(user);
    }

}
