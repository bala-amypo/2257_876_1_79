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
    private Double estimatedFuelUsage;
    private LocalDateTime generatedAt;
    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }
}