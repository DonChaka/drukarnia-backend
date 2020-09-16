package com.drukarnia.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "printer")
@Getter
@Setter
@NoArgsConstructor
public class Printer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String Brand;

    @NotEmpty
    private double cost;

    @NotEmpty
    private int quality;

    @OneToMany(mappedBy = "printer", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();

}
