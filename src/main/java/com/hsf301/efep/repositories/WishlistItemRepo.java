package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistItemRepo extends JpaRepository<WishlistItem, Integer> {
    Optional<WishlistItem> findByFlower_Id(Integer flowerId);
}
