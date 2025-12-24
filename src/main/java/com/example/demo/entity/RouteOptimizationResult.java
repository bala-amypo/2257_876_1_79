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

    private double totalDistance;
    private double fuelUsed;
    private LocalDateTime optimizedAt;

    // REQUIRED BY SERVICE
    public RouteOptimizationResult(
            Shipment shipment,
            double totalDistance,
            double fuelUsed,
            LocalDateTime optimizedAt
    ) {
        this.shipment = shipment;
        this.totalDistance = totalDistance;
        this.fuelUsed = fuelUsed;
        this.optimizedAt = optimizedAt;
    }
}
