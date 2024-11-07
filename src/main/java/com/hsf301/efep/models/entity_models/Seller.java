package com.quynh.efep_hsf.models.entity_models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`seller`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`user_id`")
    User user;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Flower> flowerList;
}
