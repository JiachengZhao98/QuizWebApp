package com.example.quizapp.service;

import com.example.quizapp.dao.UserDAO;
import com.example.quizapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean registerUser(User user) {
        // Check if email already exists
        if (userDAO.findByEmail(user.getEmail()) != null) {
            return false;
        }
        int result = userDAO.register(user);
        return result > 0;
    }

    public User authenticate(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
