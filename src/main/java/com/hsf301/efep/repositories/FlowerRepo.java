package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, int id);
}