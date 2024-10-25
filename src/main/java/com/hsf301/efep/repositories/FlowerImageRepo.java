package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.FlowerImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerImageRepo extends JpaRepository<FlowerImage ,Integer > {
}
