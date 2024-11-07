package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {
}
