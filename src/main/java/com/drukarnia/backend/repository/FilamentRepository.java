package com.drukarnia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.drukarnia.backend.entity.Filament;

@Repository
public interface FilamentRepository extends JpaRepository<Filament, Long>
{
}
