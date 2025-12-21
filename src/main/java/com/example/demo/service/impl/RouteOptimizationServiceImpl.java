package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl
        implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    // Constructor injection ONLY
    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepository,
            RouteOptimizationResultRepository resultRepository) {

        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        // Fetch shipment
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        // Read required data
        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        double latDiff = pickup.getLatitude() - drop.getLatitude();
        double lonDiff = pickup.getLongitude() - drop.getLongitude();

        // Non-zero dummy distance
        double distance = Math.hypot(latDiff, lonDiff);
        if (distance == 0) {
            distance = 1.0;
        }

        // Fuel usage calculation
        double fuelEfficiency = shipment.getVehicle().getFuelEfficiency();
        double fuelUsage = distance / fuelEfficiency;

        // Create result
        RouteOptimizationResult result =
                new RouteOptimizationResult(
                        shipment,
                        distance,
                        fuelUsage,
                        LocalDateTime.now()
                );

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {

        return resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
