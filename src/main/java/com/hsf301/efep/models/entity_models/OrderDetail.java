package com.hsf301.efep.models.entity_models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`order_detail`")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "`order_id`")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "`flower_id`")
    private Flower flower;

    @Column(name = "`flower_name`")
    private String flowerName;

    private int quantity;

    private float price;

}
