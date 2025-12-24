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
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weightKg;                 // REQUIRED
    private LocalDateTime scheduledDate;     // REQUIRED

    @ManyToOne
    private Location pickupLocation;         // REQUIRED

    @ManyToOne
    private Location dropLocation;           // REQUIRED

    @ManyToOne
    private Vehicle vehicle;                 // REQUIRED
}
