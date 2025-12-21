package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.UserService;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final UserService userService;

    public VehicleController(VehicleService vehicleService, UserService userService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
    }

    @PostMapping("/{userId}")
    public Vehicle addVehicleToUser(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        User user = userService.findById(userId); // fetch user
        vehicle.setUser(user);                   // link vehicle to user
        return vehicleService.saveVehicle(vehicle);
    }
}
