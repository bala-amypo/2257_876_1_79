package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.UserService;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final UserService userService;

    // Constructor injection
    public VehicleController(VehicleService vehicleService, UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    /**
     * Add a vehicle for a specific user
     * POST /vehicles/{userId}
     */
    @PostMapping("/{userId}")
    public Vehicle addVehicleToUser(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    /**
     * Get all vehicles for a specific user
     * GET /vehicles/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public List<Vehicle> getVehiclesByUser(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }

    /**
     * Get vehicle by its ID
     * GET /vehicles/{vehicleId}
     */
    @GetMapping("/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable Long vehicleId) {
        return vehicleService.findById(vehicleId);
    }
}
