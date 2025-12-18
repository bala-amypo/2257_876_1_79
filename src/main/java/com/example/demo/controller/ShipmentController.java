package com.example.demo.controller;
import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    @PostMapping("/{vehicleId}")
    public ResponseEntity<Shipment> createShipment(
            @PathVariable Long vehicleId,
            @RequestBody Shipment shipment) {
        return new ResponseEntity<>(shipmentService.createShipment(vehicleId, shipment),HttpStatus.CREATED);
    }
    @GetMapping("/{shipmentId}")
    public ResponseEntity<Shipment> getShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(shipmentService.getShipment(shipmentId));
    }
}
