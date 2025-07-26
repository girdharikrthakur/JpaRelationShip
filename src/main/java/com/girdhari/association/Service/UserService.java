package com.girdhari.association.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.girdhari.association.Entity.User;
import com.girdhari.association.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User user) {

        String enCodedPassword = passwordEncoder.encode(user.getAuth().getPassword());
        user.getAuth().setPassword(enCodedPassword);

        return userRepo.save(user);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

}
