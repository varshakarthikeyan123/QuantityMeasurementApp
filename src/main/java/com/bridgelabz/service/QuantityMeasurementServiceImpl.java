package com.bridgelabz.service;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.QuantityMeasurementDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements QuantityMeasurementService {

    @Autowired
    private QuantityMeasurementDatabaseRepository repository;

    @Override
    public String addQuantity(QuantityMeasurementEntity entity) {
        repository.save(entity);
        return "Saved to DB";
    }

    @Override
    public List<QuantityMeasurementEntity> getAll() {
        return repository.findAll();
    }
}