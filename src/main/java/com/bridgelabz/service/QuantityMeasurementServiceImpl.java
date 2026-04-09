package com.bridgelabz.service;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements QuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementEntity addQuantity(QuantityMeasurementEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAll() {
        return repository.findAll();
    }
}