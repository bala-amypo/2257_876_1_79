package com.example.demo.service;
import com.example.demo.entity.RouteOptimizationResult;
import java.util.List;
public interface RouteOptimizationResultService {
    RouteOptimizationResult save(RouteOptimizationResult result);
    RouteOptimizationResult getById(Long id);
    List<RouteOptimizationResult> getAll();
}
