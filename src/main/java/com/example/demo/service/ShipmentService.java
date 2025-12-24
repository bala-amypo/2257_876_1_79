package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;

public interface ShipmentService {

    Shipment createShipment(
            Shipment shipment,
            Vehicle vehicle,
            Location pickup,
            Location drop
    );

    Shipment getShipment(Long id);   // 🔴 REQUIRED
}
