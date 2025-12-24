package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final RouteOptimizationResultRepository repository;

    public RouteOptimizationServiceImpl(RouteOptimizationResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Shipment shipment) {

        double distance = 100.0;
        double fuelUsed = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult result =
                new RouteOptimizationResult(
                        shipment,
                        distance,
                        fuelUsed,
                        LocalDateTime.now()
                );

        return repository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return repository.findById(id).orElse(null);
    }
}
