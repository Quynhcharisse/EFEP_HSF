package com.quynh.efep_hsf.models.entity_models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`order`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String status;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    User user;

    @Column(name = "`buyer_name`")
    String buyerName;

    @Column(name = "`created_date`")
    LocalDateTime createdDate;

    @Column(name = "`total_price`")
    float totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<OrderDetail> orderDetailList;
}
