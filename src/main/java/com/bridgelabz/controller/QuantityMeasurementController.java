package com.bridgelabz.controller;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.service.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    @Autowired
    private QuantityMeasurementService service;

    @PostMapping("/compare")
    public boolean compare(@RequestBody QuantityDTO q1,
                           @RequestBody QuantityDTO q2) {
        return service.compare(q1, q2);
    }

    @PostMapping("/add")
    public QuantityDTO add(@RequestBody QuantityDTO q1,
                           @RequestBody QuantityDTO q2) {
        return service.add(q1, q2);
    }
}