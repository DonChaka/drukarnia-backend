package com.drukarnia.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.drukarnia.backend.entity.Filament;
import com.drukarnia.backend.service.FilamentService;

@Controller
@RequestMapping("/filaments")
public class FilamentController
{
    private final FilamentService filamentService;

    @Autowired
    public FilamentController(FilamentService filamentService)
    {
        this.filamentService = filamentService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Filament>> getAll()
    {
        return new ResponseEntity<>(filamentService.findAllFilaments(), HttpStatus.OK);
    }
}
