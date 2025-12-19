package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.*;
@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;
    @ManyToOne(optional = false)
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;
    @NotNull
    @Positive
    private Double weightKg;
    @NotNull
    private LocalDate scheduledDate;
}
