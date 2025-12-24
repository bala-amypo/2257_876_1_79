package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private double optimizedDistanceKm;      // 🔴 EXACT NAME
    private double estimatedFuelUsageL;      // 🔴 EXACT NAME

    private LocalDateTime generatedAt;        // 🔴 REQUIRED FIELD
}
