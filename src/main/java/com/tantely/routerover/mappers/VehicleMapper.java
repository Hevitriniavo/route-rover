package com.tantely.routerover.mappers;

import com.tantely.routerover.dtos.VehicleResponse;
import com.tantely.routerover.dtos.requests.VehicleRequest;
import com.tantely.routerover.entities.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    public Vehicle from(VehicleRequest request){
        return null;
    }

    public VehicleResponse from(Vehicle vehicle){
        return null;
    }
}
