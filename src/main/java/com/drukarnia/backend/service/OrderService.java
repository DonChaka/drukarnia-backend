package com.drukarnia.backend.service;

import com.drukarnia.backend.dto.OrderDTO;
import com.drukarnia.backend.entity.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drukarnia.backend.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OrderService
{
    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public Iterable<Order> findAllOrders()
    {
        return orderRepository.findAll();
    }

    public Order saveOrder(OrderDTO orderDTO)
    {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, orderDTO.getUserId());
        Printer printer = session.get(Printer.class, orderDTO.getPrinterId());
        Filament filament = session.get(Filament.class, orderDTO.getFilamentId());

        Order orderToSave = new Order(user, filament, printer);
        return orderRepository.save(orderToSave);
    }
}
