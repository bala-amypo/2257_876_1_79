package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Location pickupLocation;
    @ManyToOne
    private Location dropLocation;
    private double weightKg;
    private LocalDate scheduledDate;
    @ManyToOne
    private Vehicle vehicle;
}
