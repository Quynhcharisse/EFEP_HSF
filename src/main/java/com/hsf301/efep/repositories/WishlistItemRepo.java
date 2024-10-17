package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemRepo extends JpaRepository<WishlistItem, Integer> {
}
