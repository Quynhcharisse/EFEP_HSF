package com.hsf301.efep.models.entity_models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`flower`")
public class Flower {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "`shop_id`")
    private Shop shop;

    private String name;

    private float price;

    private String description;

    @Column(name = "`flower_amount`")
    private int flowerAmount;

    private int quantity;

    @Column(name = "`sold_quantity`")
    private int soldQuantity;

    @OneToMany(mappedBy = "flower")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<FlowerCategogy> flowerCategoryList;

    @OneToMany(mappedBy = "flower")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WishlistItem> wishlistItemList;

    @OneToMany(mappedBy = "flower")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<OrderDetail> orderDetailList;

}
