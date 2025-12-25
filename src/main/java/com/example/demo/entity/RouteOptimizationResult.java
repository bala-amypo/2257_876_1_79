package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    // ✅ matches builder().optimizedDistanceKm(...)
    private double optimizedDistanceKm;

    // ✅ matches builder().estimatedFuelUsageL(...)
    private double estimatedFuelUsageL;

    // ✅ matches builder().estimatedTimeMinutes(...)
    private long estimatedTimeMinutes;
}
