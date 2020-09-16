package com.drukarnia.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO
{
    private String uid;
    private String token;
}