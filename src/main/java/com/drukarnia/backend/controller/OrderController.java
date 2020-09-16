package com.drukarnia.backend.controller;

import com.drukarnia.backend.dto.OrderDTO;
import com.drukarnia.backend.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.drukarnia.backend.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController
{
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Order>> getAllUsers()
    {
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Iterable<Order>> getUserOrders(@PathVariable double userId)
    {
        List<Order> toReturn = new ArrayList<>();

        for (Order order : orderService.findAllOrders())
        {
            if(order.getUser().getId() == userId)
                toReturn.add(order);
        }
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> newOrder(@RequestBody OrderDTO orderDTO)
    {
        return new ResponseEntity<>(orderService.saveOrder(orderDTO), HttpStatus.OK);
    }
}
