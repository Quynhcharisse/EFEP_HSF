package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Integer> {
}
