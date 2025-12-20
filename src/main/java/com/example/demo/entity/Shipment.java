package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment() {}

    public Shipment(Double weightKg, LocalDate scheduledDate) {
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }

    public Long getId() { return id; }
    public Double getWeightKg() { return weightKg; }
    public LocalDate getScheduledDate() { return scheduledDate; }

    public void setId(Long id) { this.id = id; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }
}
