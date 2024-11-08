package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepo extends JpaRepository<Flower, Integer> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, int id);

    int countByStatus(String status);

    Page<Flower> findAllByStatus(String status, Pageable pageable);

    Page<Flower> findAllByStatusAndNameContainingIgnoreCase(String status, String name, Pageable pageable);

    List<Flower> findAllByStatus(String status);

    List<Flower> findAllByCategory_IdAndStatus(int id, String status);
}
