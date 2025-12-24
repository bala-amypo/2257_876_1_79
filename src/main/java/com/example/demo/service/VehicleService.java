package com.example.demo.service;

import com.example.demo.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long id);
}
