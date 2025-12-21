package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "vehicleNumber")
    }
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Owner
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private String vehicleNumber;

    private Double capacityKg;

    private Double fuelEfficiency;

    // Inverse side (Shipment not implemented here)
    @OneToMany(mappedBy = "vehicle")
    private List<Shipment> shipments;

    // No-arg constructor
    public Vehicle() {
    }

    // Parameterized constructor
    public Vehicle(User user,
                   String vehicleNumber,
                   Double capacityKg,
                   Double fuelEfficiency) {
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacityKg = capacityKg;
        this.fuelEfficiency = fuelEfficiency;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}
