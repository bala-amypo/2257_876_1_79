package com.example.demo.service;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
public interface RouteOptimizationService {
    RouteOptimizationResult optimizeRoute(Shipment shipment);
}
