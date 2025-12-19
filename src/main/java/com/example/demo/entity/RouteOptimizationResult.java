package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.*;
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
    @ManyToOne(optional = false)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
    @NotNull
    @Positive
    private Double optimizedDistanceKm;
    @NotNull
    @Positive
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;
    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }
}
