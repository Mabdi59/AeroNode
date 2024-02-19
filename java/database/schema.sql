BEGIN TRANSACTION;

DROP TABLE IF EXISTS Tickets;
DROP TABLE IF EXISTS Passengers;
DROP TABLE IF EXISTS Flights;
DROP TABLE IF EXISTS Aircraft;
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Create Aircraft table
CREATE TABLE Aircraft (
    AircraftID SERIAL PRIMARY KEY,
    RegistrationNumber VARCHAR(20) NOT NULL UNIQUE,
    Model VARCHAR(50) NOT NULL,
    Manufacturer VARCHAR(50),
    Capacity INT
);

-- Create Flights table
CREATE TABLE Flights (
    FlightID SERIAL PRIMARY KEY,
    FlightNumber VARCHAR(10) NOT NULL UNIQUE,
    DepartureAirport VARCHAR(50) NOT NULL,
    ArrivalAirport VARCHAR(50) NOT NULL,
    DepartureTime TIMESTAMP NOT NULL,
    ArrivalTime TIMESTAMP NOT NULL,
    AircraftID INT REFERENCES Aircraft(AircraftID) ON DELETE SET NULL
);

-- Create Passengers table
CREATE TABLE Passengers (
    PassengerID SERIAL PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20)
);

-- Create Tickets table
CREATE TABLE Tickets (
    TicketID SERIAL PRIMARY KEY,
    FlightID INT REFERENCES Flights(FlightID) ON DELETE CASCADE,
    PassengerID INT REFERENCES Passengers(PassengerID) ON DELETE CASCADE,
    BookingTime TIMESTAMP DEFAULT NOW(),
    SeatNumber VARCHAR(10),
    Price DECIMAL(10, 2)
);

COMMIT;
