package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    @Override
    public RouteOptimizationResult optimizeRoute(
            double distance,
            double fuelEfficiency,
            double fuelPrice
    ) {

        double fuelUsed = distance / fuelEfficiency;
        double totalCost = fuelUsed * fuelPrice;

        return RouteOptimizationResult.builder()
                .distance(distance)
                .fuelUsed(fuelUsed)
                .totalCost(totalCost)
                .build();
    }
}
