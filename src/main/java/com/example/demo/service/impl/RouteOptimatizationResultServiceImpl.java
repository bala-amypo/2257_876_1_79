package com.example.demo.service.impl;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.service.RouteOptimizationResultService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RouteOptimizationResultServiceImpl
        implements RouteOptimizationResultService {
    private final RouteOptimizationResultRepository repository;
    public RouteOptimizationResultServiceImpl(
            RouteOptimizationResultRepository repository) {
        this.repository = repository;
    }
    @Override
    public RouteOptimizationResult save(RouteOptimizationResult result) {
        return repository.save(result);
    }
    @Override
    public RouteOptimizationResult getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("RouteOptimizationResult not found"));
    }
    @Override
    public List<RouteOptimizationResult> getAll() {
        return repository.findAll();
    }
}
