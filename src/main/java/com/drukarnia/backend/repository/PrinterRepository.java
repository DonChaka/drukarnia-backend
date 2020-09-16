package com.drukarnia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.drukarnia.backend.entity.Printer;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PrinterRepository extends JpaRepository<Printer, Long>
{
    Iterable<Printer> findAllByName(String name);
}
