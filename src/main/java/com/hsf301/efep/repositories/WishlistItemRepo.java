package com.quynh.efep_hsf.repositories;

import com.quynh.efep_hsf.models.entity_models.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistItemRepo extends JpaRepository<WishlistItem, Integer> {
    Optional<WishlistItem> findByFlower_IdAndWishlist_User_Account_Id(int flowerId, int accountId);

    List<WishlistItem> findAllByWishlist_Id(int wishlistId);
}
