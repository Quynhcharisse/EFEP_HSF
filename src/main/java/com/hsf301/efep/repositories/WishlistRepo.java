package com.hsf301.efep.repositories;

import com.hsf301.efep.models.entity_models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {
    Optional<Wishlist> findByUser_Account_Id(int id);
}
