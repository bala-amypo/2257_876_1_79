package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeService;

    public RouteOptimizationController(RouteOptimizationService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/{shipmentId}")
    public ResponseEntity<RouteOptimizationResult> optimize(
            @PathVariable Long shipmentId) {

        return new ResponseEntity<>(
                routeService.optimizeRoute(shipmentId),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/result/{resultId}")
    public ResponseEntity<RouteOptimizationResult> getResult(
            @PathVariable Long resultId) {
        return ResponseEntity.ok(routeService.getResult(resultId));
    }
}
