package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository, 
                                       RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        // Calculation: Compute dummy distance (Euclidean)
        double latDiff = shipment.getDropLocation().getLatitude() - shipment.getPickupLocation().getLatitude();
        double lonDiff = shipment.getDropLocation().getLongitude() - shipment.getPickupLocation().getLongitude();
        double distance = Math.hypot(latDiff, lonDiff);
        
        // Ensure distance is non-zero as per rules
        if (distance <= 0) distance = 1.0;

        // Calculation: Fuel = distance / efficiency
        double fuelEfficiency = shipment.getVehicle().getFuelEfficiency();
        double fuelUsage = distance / (fuelEfficiency > 0 ? fuelEfficiency : 1.0);

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(distance);
        result.setEstimatedFuelUsageL(fuelUsage);
        
        // Rule: generatedAt must be set to now automatically
        result.setGeneratedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
