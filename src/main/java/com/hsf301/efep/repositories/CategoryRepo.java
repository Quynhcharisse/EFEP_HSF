package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
