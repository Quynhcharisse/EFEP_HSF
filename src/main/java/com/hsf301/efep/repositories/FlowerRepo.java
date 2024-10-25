package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {

    Optional<Flower> findByName(String name);

    List<Flower> findByShop_Id(int id);
}
