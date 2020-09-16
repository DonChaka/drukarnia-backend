package com.drukarnia.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drukarnia.backend.entity.Filament;
import com.drukarnia.backend.repository.FilamentRepository;

@Service
public class FilamentService
{
    private final FilamentRepository filamentRepository;

    @Autowired
    public FilamentService(FilamentRepository filamentRepository)
    {
        this.filamentRepository = filamentRepository;
    }

    public Iterable<Filament> findAllFilaments()
    {
        return filamentRepository.findAll();
    }
}
