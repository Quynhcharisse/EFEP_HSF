package com.quynh.efep_hsf.models.entity_models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`wishlist`")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`user_id`")
    User user;

    @OneToMany(mappedBy = "wishlist", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<WishlistItem> wishlistItemList;
}
