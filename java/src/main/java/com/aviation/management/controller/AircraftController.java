package com.aviation.management.controller;

import com.aviation.management.model.Aircraft;
import com.aviation.management.dao.AircraftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {

    private final AircraftDao aircraftDao;

    @Autowired
    public AircraftController(AircraftDao aircraftDao) {
        this.aircraftDao = aircraftDao;
    }

    @GetMapping
    public List<Aircraft> getAllAircrafts() {
        return aircraftDao.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable("id") int id) {
        return aircraftDao.getAircraftById(id);
    }

    @PostMapping
    public ResponseEntity<?> addAircraft(@RequestBody Aircraft aircraft) {
        aircraftDao.addAircraft(aircraft);
        return ResponseEntity.ok().body("Aircraft added successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAircraft(@PathVariable("id") int id, @RequestBody Aircraft aircraft) {
        aircraft.setAircraftID(id);
        aircraftDao.updateAircraft(aircraft);
        return ResponseEntity.ok().body("Aircraft updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAircraft(@PathVariable("id") int id) {
        aircraftDao.deleteAircraft(id);
        return ResponseEntity.ok().body("Aircraft deleted successfully.");
    }
}
