package com.bridgelabz.quantity_measurement_app.dao;

import com.bridgelabz.quantity_measurement_app.config.ConnectionPool;
import com.bridgelabz.quantity_measurement_app.exception.DatabaseException;
import com.bridgelabz.quantity_measurement_app.model.QuantityMeasurementEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementRepository {

    // ---------------- SAVE ----------------

    public void saveMeasurement(QuantityMeasurementEntity entity) {

        String query = """
                INSERT INTO measurement
                (value, unit, measurement_type, operation, result)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDouble(1, entity.getValue());
            stmt.setString(2, entity.getUnit());
            stmt.setString(3, entity.getMeasurementType());
            stmt.setString(4, entity.getOperation());
            stmt.setString(5, entity.getResult());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new DatabaseException("Failed to save measurement", e);
        }
    }

    // ---------------- FIND ALL ----------------

    public List<QuantityMeasurementEntity> findAllMeasurements() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String query = "SELECT * FROM measurement";

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                QuantityMeasurementEntity entity =
                        new QuantityMeasurementEntity();

                entity.setId(rs.getInt("id"));
                entity.setValue(rs.getDouble("value"));
                entity.setUnit(rs.getString("unit"));
                entity.setMeasurementType(rs.getString("measurement_type"));
                entity.setOperation(rs.getString("operation"));
                entity.setResult(rs.getString("result"));

                list.add(entity);
            }

        } catch (Exception e) {
            throw new DatabaseException("Failed to fetch measurements", e);
        }

        return list;
    }

    // ---------------- FIND BY TYPE ----------------

    public List<QuantityMeasurementEntity> findByMeasurementType(String type) {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String query = "SELECT * FROM measurement WHERE measurement_type = ?";

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, type);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                QuantityMeasurementEntity entity =
                        new QuantityMeasurementEntity();

                entity.setId(rs.getInt("id"));
                entity.setValue(rs.getDouble("value"));
                entity.setUnit(rs.getString("unit"));
                entity.setMeasurementType(rs.getString("measurement_type"));
                entity.setOperation(rs.getString("operation"));
                entity.setResult(rs.getString("result"));

                list.add(entity);
            }

        } catch (Exception e) {
            throw new DatabaseException("Failed to fetch measurements by type", e);
        }

        return list;
    }

    // ---------------- DELETE ----------------

    public void deleteMeasurement(int id) {

        String query = "DELETE FROM measurement WHERE id = ?";

        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new DatabaseException("Failed to delete measurement", e);
        }
    }
}