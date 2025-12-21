package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    // Constructor injection ONLY
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository,
                               VehicleRepository vehicleRepository,
                               LocationRepository locationRepository) {
        this.shipmentRepository = shipmentRepository;
        this.vehicleRepository = vehicleRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {

        // Fetch vehicle
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        // Fetch pickup location (only ID present initially)
        Long pickupId = shipment.getPickupLocation().getId();
        Location pickup = locationRepository.findById(pickupId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Location not found"));

        // Fetch drop location
        Long dropId = shipment.getDropLocation().getId();
        Location drop = locationRepository.findById(dropId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Location not found"));

        // Weight validation
        if (shipment.getWeightKg() != null &&
            shipment.getWeightKg() > vehicle.getCapacityKg()) {

            throw new IllegalArgumentException("exceeds");
        }

        // Date validation
        if (shipment.getScheduledDate() != null &&
            shipment.getScheduledDate().isBefore(LocalDate.now())) {

            throw new IllegalArgumentException("past");
        }

        // Attach real entities
        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipment(Long shipmentId) {
        return shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));
    }
}
