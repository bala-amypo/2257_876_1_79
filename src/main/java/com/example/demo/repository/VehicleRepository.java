package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional; // Ensure this import is present

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    // Required by the Service logic
    List<Vehicle> findByUserId(Long userId);

    // Add this method to fix the "cannot find symbol" error in your tests
    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
}
