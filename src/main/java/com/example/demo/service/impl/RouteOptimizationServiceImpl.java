package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.service.RouteOptimizationResultService;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl
        implements RouteOptimizationService {

    private final RouteOptimizationResultService resultService;

    public RouteOptimizationServiceImpl(
            RouteOptimizationResultService resultService) {
        this.resultService = resultService;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Shipment shipment) {

        double distance = 120.0;
        double fuelCost = distance * 5;

        RouteOptimizationResult result =
                new RouteOptimizationResult(
                        null,
                        shipment,
                        distance,
                        fuelCost,
                        LocalDateTime.now()
                );

        return resultService.save(result);
    }
}
