package com.tantely.routerover.controllers;

import com.tantely.routerover.dtos.VehicleResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vehicles")
public class VehicleController {
    @GetMapping
    public List<VehicleResponse> getAllVehicles() {
        return List.of();
    }
}
