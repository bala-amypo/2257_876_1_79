package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class Location {
    @Id
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
       public Location() {
    }
    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Shipment() {
    }
    public Shipment(Vehicle vehicle, Location pickupLocation, Location dropLocation,Double weightKg, LocalDate scheduledDate){
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }
     public RouteOptimizationResult() {
    }
    public RouteOptimizationResult(Shipment shipment, Double optimizedDistanceKm,Double estimatedFuelUsageL) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
    }
}
