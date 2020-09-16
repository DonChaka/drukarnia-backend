package com.drukarnia.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderDTO
{
    private long userId;
    private long printerId;
    private long filamentId;
}
