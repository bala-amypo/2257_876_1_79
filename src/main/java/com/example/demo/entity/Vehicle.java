package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
    name = "vehicles",
    uniqueConstraints = @UniqueConstraint(columnNames = "vehicleNumber")
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;

    private Double capacityKg;

    private Double fuelEfficiency;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "vehicle")
    private List<Shipment> shipments;

    // No-arg constructor
    public Vehicle() {
    }

    // Parameterized constructor (EXACT order)
    public Vehicle(User user, String vehicleNumber, Double capacityKg, Double fuelEfficiency) {
        this.user = user;
        this.vehicleNumber = vehicleNumber;
        this.capacityKg = capacityKg;
        this.fuelEfficiency = fuelEfficiency;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
