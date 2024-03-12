package com.aviation.management.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Aircraft {

    private int aircraftID;
    private String registrationNumber;
    private String model;
    private String manufacturer;
    private int capacity;
    private Integer yearOfManufacture;
    private LocalDateTime lastServiceDate;

    // Constructors,
    public Aircraft(int aircraftID, String registrationNumber, String model, String manufacturer, int capacity, Integer yearOfManufacture, LocalDateTime lastServiceDate) {
        this.aircraftID = aircraftID;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.yearOfManufacture = yearOfManufacture;
        this.lastServiceDate = lastServiceDate;
    }

    // Getters, and Setters
    public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public LocalDateTime getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(LocalDateTime lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Aircraft() {
    }

    // hashCode, equals, and toString methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return aircraftID == aircraft.aircraftID && capacity == aircraft.capacity && Objects.equals(registrationNumber, aircraft.registrationNumber) && Objects.equals(model, aircraft.model) && Objects.equals(manufacturer, aircraft.manufacturer) && Objects.equals(yearOfManufacture, aircraft.yearOfManufacture) && Objects.equals(lastServiceDate, aircraft.lastServiceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftID, registrationNumber, model, manufacturer, capacity, yearOfManufacture, lastServiceDate);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftID=" + aircraftID +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                ", yearOfManufacture=" + yearOfManufacture +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
