package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @GetMapping("/optimize")
    public RouteOptimizationResult optimizeRoute(
            @RequestParam double distance,
            @RequestParam double fuelEfficiency,
            @RequestParam double fuelPrice
    ) {
        return routeOptimizationService.optimizeRoute(
                distance,
                fuelEfficiency,
                fuelPrice
        );
    }
}
