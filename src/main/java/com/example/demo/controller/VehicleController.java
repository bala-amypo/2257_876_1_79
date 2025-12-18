package com.example.demo.controller;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @PostMapping("/{userId}")
    public ResponseEntity<Vehicle> addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(
                vehicleService.addVehicle(userId, vehicle),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable Long userId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByUser(userId));
    }
}
