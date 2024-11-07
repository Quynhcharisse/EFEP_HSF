package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmailAndPassword(String email, String password);

    Optional<Account> findByUserName(String name);

    Optional<Account> findByUserPhone(String phone);

    Optional<Object> findByEmail(String email);
}
