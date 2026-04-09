package com.bridgelabz.service;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import java.util.List;

public interface QuantityMeasurementService {

    String addQuantity(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAll();
}