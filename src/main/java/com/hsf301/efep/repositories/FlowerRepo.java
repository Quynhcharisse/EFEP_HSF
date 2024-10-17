package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {
}
