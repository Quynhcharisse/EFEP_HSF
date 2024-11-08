package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Integer> {
}
