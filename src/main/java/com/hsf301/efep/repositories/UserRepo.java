package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Account;
import com.quynh.efep_hsf.models.entity_models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Account, Integer> {
    Optional<User> findByName(String name);

    Optional<User> findByPhone(String phone);
}
