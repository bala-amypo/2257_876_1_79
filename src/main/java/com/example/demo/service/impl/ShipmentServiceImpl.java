package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment, Vehicle vehicle,
                                   Location pickup, Location drop) {

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new RuntimeException("Vehicle capacity exceeded");
        }

        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);

        return shipmentRepository.save(shipment);
    }
}
