package com.hsf301.efep.models.entity_models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`flower`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String status;

    @ManyToOne
    @JoinColumn(name = "`seller_id`")
    Seller seller;

    String img;

    String name;

    float price;

    String description;

    @Column(name = "`flower_amount`")
    int flowerAmount;

    int quantity;

    @Column(name = "`sold_quantity`")
    int soldQuantity;

    @ManyToOne
    @JoinColumn(name = "`category_id`")
    Category category;

    @OneToMany(mappedBy = "flower", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<WishlistItem> wishlistItemList;

    @OneToMany(mappedBy = "flower", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<OrderDetail> orderDetailList;

}
