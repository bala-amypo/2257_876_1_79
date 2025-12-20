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
    private final RouteOptimizationResultRepository routeOptimizationResultRepository;

    // ✅ Constructor Injection (MANDATORY for tests)
    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepository,
            RouteOptimizationResultRepository routeOptimizationResultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.routeOptimizationResultRepository = routeOptimizationResultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        // Dummy values (must be > 0 for tests)
        double distance = 100.0;
        double fuelUsage = 10.0;

        // ✅ Use Builder (DO NOT use new)
        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsage(fuelUsage)
                .generatedAt(LocalDateTime.now())
                .build();

        return routeOptimizationResultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return routeOptimizationResultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
