package com.tantely.routerover.mappers;

import com.tantely.routerover.dtos.UserResponse;
import com.tantely.routerover.dtos.requests.UserRequest;
import com.tantely.routerover.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User from(UserRequest request) {
        return null;
    }

    public UserResponse from(User user) {
        return null;
    }
}
