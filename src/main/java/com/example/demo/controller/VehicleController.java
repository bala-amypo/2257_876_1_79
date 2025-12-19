package com.example.demo.controller;
import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @PostMapping("/{userId}")
    public ApiResponse addVehicle(@PathVariable Long userId,@RequestBody Vehicle vehicle){
        Vehicle savedVehicle = vehicleService.addVehicle(userId, vehicle);
        return new ApiResponse(true, "Vehicle added successfully", savedVehicle);
    }
    @GetMapping("/user/{userId}")
    public List<Vehicle> getVehiclesByUser(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }
}
