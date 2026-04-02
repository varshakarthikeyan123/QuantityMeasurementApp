package com.bridgelabz.repository;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private final List<QuantityMeasurementEntity> list = new ArrayList<>();

    @Override
    public void save(QuantityMeasurementEntity entity) {
        list.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {
        return list;
    }
}