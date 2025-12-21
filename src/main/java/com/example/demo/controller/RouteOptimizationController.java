package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    // Constructor injection
    public RouteOptimizationController(
            RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    // ✅ POST /optimize/{shipmentId}
    // Access: Protected by JWT (assumed)
    @PostMapping("/{shipmentId}")
    public RouteOptimizationResult optimizeRoute(
            @PathVariable Long shipmentId) {

        return routeOptimizationService.optimizeRoute(shipmentId);
    }

    // ✅ GET /optimize/result/{resultId}
    // Access: Protected by JWT (assumed)
    @GetMapping("/result/{resultId}")
    public RouteOptimizationResult getResult(
            @PathVariable Long resultId) {

        return routeOptimizationService.getResult(resultId);
    }
}
