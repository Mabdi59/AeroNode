package com.aviation.management.dao;

import com.aviation.management.model.Aircraft;
import java.util.List;
public interface AircraftDao {
    List<Aircraft> getAllAircrafts();

    Aircraft getAircraftById(int aircraftID);

    void addAircraft(Aircraft aircraft);

    void updateAircraft(Aircraft aircraft);

    void deleteAircraft(int aircraftID);
}
