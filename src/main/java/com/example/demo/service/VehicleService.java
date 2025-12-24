package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle, User user);

    Vehicle findById(Long id);   // 🔴 REQUIRED
}
