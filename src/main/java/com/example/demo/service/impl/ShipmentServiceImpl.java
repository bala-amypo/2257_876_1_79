package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ShipmentService;

import java.time.LocalDate;

public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;
    private final LocationRepository locationRepo;

    public ShipmentServiceImpl(ShipmentRepository s, VehicleRepository v, LocationRepository l) {
        this.shipmentRepo = s;
        this.vehicleRepo = v;
        this.locationRepo = l;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {

        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        Location pickup = locationRepo.findById(shipment.getPickupLocation().getId()).orElseThrow();
        Location drop = locationRepo.findById(shipment.getDropLocation().getId()).orElseThrow();

        if (shipment.getWeightKg() > vehicle.getCapacityKg())
            throw new IllegalArgumentException("exceeds capacity");

        if (shipment.getScheduledDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("past date");

        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);

        return shipmentRepo.save(shipment);
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
