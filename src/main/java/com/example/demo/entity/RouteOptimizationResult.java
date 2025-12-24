package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteOptimizationResult {

    private double distance;
    private double fuelUsed;
    private double totalCost;
}
