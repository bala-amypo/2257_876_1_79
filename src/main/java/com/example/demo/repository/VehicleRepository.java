package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // used in multiple tests
    List<Vehicle> findByUserId(Long userId);

    // 🔴 REQUIRED by TransportRouteOptimizationTest (t20)
    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
}
