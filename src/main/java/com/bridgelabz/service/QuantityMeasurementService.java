package com.bridgelabz.service;

import com.bridgelabz.dto.QuantityDTO;

public interface QuantityMeasurementService {
    boolean compare(QuantityDTO q1, QuantityDTO q2);
    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);
}