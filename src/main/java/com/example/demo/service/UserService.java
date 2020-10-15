package com.example.demo.service;

import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();
    void saveUser(User user);
    void deleteUserById(long id);
    User getUserById(long id);
}
