package com.girdhari.association.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.girdhari.association.DTO.APIResponse;
import com.girdhari.association.Entity.User;
import com.girdhari.association.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<APIResponse<User>> addUser(@RequestBody User user) {

        User addedUser = userService.addUser(user);

        APIResponse<User> response = new APIResponse<>(addedUser.getUserid(), user);

        return ResponseEntity.ok(response);

    }

    @GetMapping()
    public ResponseEntity<APIResponse<List<User>>> getAllUser() {
        List<User> user = userService.getAllUser();

        APIResponse<List<User>> response = new APIResponse<>(user.size(), user);

        return ResponseEntity.ok(response);
    }

}
