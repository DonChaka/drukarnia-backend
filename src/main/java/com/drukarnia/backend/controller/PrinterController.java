package com.drukarnia.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.drukarnia.backend.entity.Printer;
import com.drukarnia.backend.service.PrinterService;

@Controller
@RequestMapping("/printers")
public class PrinterController
{
    private final PrinterService printerService;

    @Autowired
    public PrinterController(PrinterService printerService)
    {
        this.printerService = printerService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Printer>> getAll()
    {
        return new ResponseEntity<>(printerService.findAllPrinters(), HttpStatus.OK);
    }
}
