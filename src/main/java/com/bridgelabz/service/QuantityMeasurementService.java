package com.bridgelabz.service;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import java.util.List;

public interface QuantityMeasurementService {

    QuantityMeasurementEntity addQuantity(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAll();
}