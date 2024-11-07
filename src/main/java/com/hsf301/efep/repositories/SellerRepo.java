package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Integer> {
}
