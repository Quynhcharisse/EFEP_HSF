package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
