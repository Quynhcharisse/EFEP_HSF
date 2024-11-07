package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Account findByRole(String role);
}
