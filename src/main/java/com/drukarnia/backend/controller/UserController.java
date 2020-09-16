package com.drukarnia.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.drukarnia.backend.entity.User;
import com.drukarnia.backend.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAll()
    {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestBody String user)
    {
        return new ResponseEntity<>(userService.findByUsername(user), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<User> newUser(@RequestBody User newUser)
    {
        User check =  userService.findByUsername(newUser.getUsername());
        if(check == null)
            return new ResponseEntity<>(userService.saveUser(newUser), HttpStatus.CREATED);
        return new ResponseEntity<>(newUser, HttpStatus.CONFLICT);
    }

}
