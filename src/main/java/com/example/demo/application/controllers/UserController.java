package com.example.demo.application.controllers;

import java.util.List;
import java.util.Map;

import com.example.demo.application.entities.User;
import com.example.demo.application.repositories.Users;
import com.example.demo.application.repositories.UserRepository;
import com.example.demo.application.services.IUserService;
import com.example.demo.application.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

//    @PostMapping("/users")
//    void addUser(@RequestBody User user) {
//        userRepository.save(user);
//    }

    @PostMapping("/users")
    public void addUser(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        userRepository.save(new User(username, password));
    }

    @DeleteMapping("/delete-user/{user_id}")
    public void deleteUser(@PathVariable("user_id") int user_id, User user) {userRepository.delete(user);}

    @PostMapping("/edit-user/{user_id}")
    public void editUser (@RequestBody User user,@PathVariable("user_id") int user_id) {
        userRepository.findById(user_id);
    }
}
