package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    private Double optimizedDistanceKm;

    // ✅ IMPORTANT: exact name expected by tests
    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    @PrePersist
    protected void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }
}
