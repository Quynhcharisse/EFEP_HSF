package com.quynh.efep_hsf.models.entity_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`order_detail`")

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "`order_id`")
    Order order;

    @ManyToOne
    @JoinColumn(name = "`flower_id`")
    Flower flower;

    @Column(name = "`flower_name`")
    String flowerName;

    int quantity;

    float price;
}
