package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;

public interface RouteOptimizationService {

    RouteOptimizationResult optimizeRoute(
            double distance,
            double fuelEfficiency,
            double fuelPrice
    );
}
