package com.bridgelabz.repository;

import com.bridgelabz.model.Quantity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository {

    public void save(Quantity quantity) {
        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO quantity_measurement(value, unit) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, quantity.getValue());
            ps.setString(2, quantity.getUnit());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Quantity> findAll() {
        List<Quantity> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM quantity_measurement";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Quantity q = new Quantity();
                q.setValue(rs.getDouble("value"));
                q.setUnit(rs.getString("unit"));
                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
