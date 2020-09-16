package com.drukarnia.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drukarnia.backend.entity.Printer;
import com.drukarnia.backend.repository.PrinterRepository;

@Service
public class PrinterService
{
    private final PrinterRepository printerRepository;

    @Autowired
    public PrinterService(PrinterRepository printerRepository)
    {
        this.printerRepository = printerRepository;
    }

    public Iterable<Printer> findAllPrinters()
    {
        return printerRepository.findAll();
    }
}
