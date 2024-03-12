package com.aviation.management.dao;

import com.aviation.management.model.Aircraft;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JdbcAircraftDao implements AircraftDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAircraftDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        String sql = "SELECT * FROM Aircraft";
        return jdbcTemplate.query(sql, aircraftRowMapper());
    }

    @Override
    public Aircraft getAircraftById(int aircraftID) {
        String sql = "SELECT * FROM Aircraft WHERE AircraftID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{aircraftID}, aircraftRowMapper());
    }

    @Override
    public void addAircraft(Aircraft aircraft) {
        String sql = "INSERT INTO Aircraft (RegistrationNumber, Model, Manufacturer, Capacity, YearOfManufacture, LastServiceDate) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, aircraft.getRegistrationNumber(), aircraft.getModel(), aircraft.getManufacturer(), aircraft.getCapacity(), aircraft.getYearOfManufacture(), aircraft.getLastServiceDate());
    }

    @Override
    public void updateAircraft(Aircraft aircraft) {
        String sql = "UPDATE Aircraft SET RegistrationNumber = ?, Model = ?, Manufacturer = ?, Capacity = ?, YearOfManufacture = ?, LastServiceDate = ? WHERE AircraftID = ?";
        jdbcTemplate.update(sql, aircraft.getRegistrationNumber(), aircraft.getModel(), aircraft.getManufacturer(), aircraft.getCapacity(), aircraft.getYearOfManufacture(), aircraft.getLastServiceDate(), aircraft.getAircraftID());
    }

    @Override
    public void deleteAircraft(int aircraftID) {
        String sql = "DELETE FROM Aircraft WHERE AircraftID = ?";
        jdbcTemplate.update(sql, aircraftID);
    }

    private RowMapper<Aircraft> aircraftRowMapper() {
        return (rs, rowNum) -> {
            Aircraft aircraft = new Aircraft();
            aircraft.setAircraftID(rs.getInt("AircraftID"));
            aircraft.setRegistrationNumber(rs.getString("RegistrationNumber"));
            aircraft.setModel(rs.getString("Model"));
            aircraft.setManufacturer(rs.getString("Manufacturer"));
            aircraft.setCapacity(rs.getInt("Capacity"));
            aircraft.setYearOfManufacture(rs.getObject("YearOfManufacture") != null ? rs.getInt("YearOfManufacture") : null);
            aircraft.setLastServiceDate(rs.getTimestamp("LastServiceDate") != null ? rs.getTimestamp("LastServiceDate").toLocalDateTime() : null);
            return aircraft;
        };
    }
}
