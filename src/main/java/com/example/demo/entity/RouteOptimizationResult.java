package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;
    public RouteOptimizationResult() {}
    public RouteOptimizationResult(Shipment shipment,
                                   Double optimizedDistanceKm,
                                   Double estimatedFuelUsageL,
                                   LocalDateTime generatedAt) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }
}
