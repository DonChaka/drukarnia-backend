package com.drukarnia.backend.entity;

import com.drukarnia.backend.model.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Filament filament;

    @ManyToOne
    private Printer printer;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(User user, Filament filament, Printer printer)
    {
        this.user = user;
        this.filament = filament;
        this.printer = printer;
        status = Status.PENDING;
    }
}
