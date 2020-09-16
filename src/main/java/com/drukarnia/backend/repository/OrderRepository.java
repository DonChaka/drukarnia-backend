package com.drukarnia.backend.repository;

import com.drukarnia.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.drukarnia.backend.entity.Order;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>
{
    Iterable<Order> findAllById(Long id);
    Iterable<Order> findAllByUser(User user);
}
