package com.drukarnia.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filament")
@Getter
@Setter
@NoArgsConstructor
public class Filament
{
    enum type{
        PLA,
        ABS,
        PETG,
        NYLON
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String Brand;

    private String type;

    private boolean flexible;

    private String colour;

    private double cost;

    @OneToMany (mappedBy = "filament", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();
}
