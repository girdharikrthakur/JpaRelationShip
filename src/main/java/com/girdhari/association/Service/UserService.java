package com.girdhari.association.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girdhari.association.Entity.User;
import com.girdhari.association.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

}
