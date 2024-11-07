package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByPhone(String phone);
}
