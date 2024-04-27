package com.tantely.routerover.repositories;

import com.tantely.routerover.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
