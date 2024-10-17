package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {
}
