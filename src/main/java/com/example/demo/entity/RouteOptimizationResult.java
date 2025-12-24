package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "route_optimization_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Distance in km
    private double distance;

    // Fuel consumed in liters
    private double fuelUsed;

    // Total cost
    private double totalCost;

    // Optional relation to Shipment
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
}
