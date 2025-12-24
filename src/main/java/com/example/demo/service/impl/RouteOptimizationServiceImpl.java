package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RouteOptimizationService;

import java.time.LocalDateTime;

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
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        double distance = Math.random() * 100 + 1;
        double fuel = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult result =
                RouteOptimizationResult.builder()
                        .shipment(shipment)
                        .optimizedDistanceKm(distance)
                        .estimatedFuelUsageL(fuel)
                        .generatedAt(LocalDateTime.now())
                        .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
