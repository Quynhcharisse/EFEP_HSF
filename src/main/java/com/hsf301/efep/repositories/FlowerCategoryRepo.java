package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.FlowerCategogy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerCategoryRepo extends JpaRepository<FlowerCategogy, Integer> {
}
