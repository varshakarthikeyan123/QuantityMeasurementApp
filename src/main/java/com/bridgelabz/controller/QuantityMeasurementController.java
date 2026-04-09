package com.bridgelabz.controller;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.service.QuantityMeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    private final QuantityMeasurementService service;

    public QuantityMeasurementController(QuantityMeasurementService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public QuantityMeasurementEntity save(@RequestBody QuantityMeasurementEntity entity) {
        return service.addQuantity(entity);
    }

    @GetMapping("/all")
    public List<QuantityMeasurementEntity> getAll() {
        return service.getAll();
    }
}