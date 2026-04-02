package com.bridgelabz.service;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.model.LengthUnit;
import com.bridgelabz.model.Quantity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementServiceImpl implements QuantityMeasurementService {

    @Autowired
    private IQuantityMeasurementRepository repository;

    private Quantity convertToModel(QuantityDTO dto) {
        return new Quantity(dto.getValue(), LengthUnit.valueOf(dto.getUnit().toUpperCase()));
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return convertToModel(q1).compare(convertToModel(q2));
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        Quantity result = convertToModel(q1).add(convertToModel(q2));

        QuantityDTO dto = new QuantityDTO(result.toBase(), "INCHES");

        repository.save(new QuantityMeasurementEntity(dto.getValue(), dto.getUnit(), "ADD"));

        return dto;
    }
}