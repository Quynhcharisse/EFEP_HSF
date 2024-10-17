package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
