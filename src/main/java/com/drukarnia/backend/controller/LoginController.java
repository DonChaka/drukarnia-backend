package com.drukarnia.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.drukarnia.backend.dto.LoginResponseDTO;
import com.drukarnia.backend.entity.User;
import com.drukarnia.backend.service.UserService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;

import static com.drukarnia.backend.SecurityConfig.SECRET_512;

@RestController
public class LoginController
{
    @Getter
    public static class LoginData
    {
        private String username;
        private String password;
    }

    private static final int TOKEN_LIFESPAN = 1000 * 60 * 60;

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("users/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginData loginData)
    {

        User user = userService.findByUsername(loginData.getUsername());

        if (user == null || !bCryptPasswordEncoder.matches(loginData.getPassword(), user.getPassword()))
            return new ResponseEntity(HttpStatus.FORBIDDEN);

        String token = JWT.create()
                .withSubject(user.getId().toString())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_LIFESPAN))
                .sign(Algorithm.HMAC512(SECRET_512));

        LoginResponseDTO response = new LoginResponseDTO(user.getId().toString(), token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
