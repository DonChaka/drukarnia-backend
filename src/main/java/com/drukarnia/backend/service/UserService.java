package com.drukarnia.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.drukarnia.backend.entity.User;
import com.drukarnia.backend.repository.UserRepository;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Iterable<User> findAllUsers()
    {
        return userRepository.findAll();
    }

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }


    public User saveUser(User newUser)
    {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }
}
