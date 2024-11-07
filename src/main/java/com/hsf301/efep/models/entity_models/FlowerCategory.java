package com.quynh.efep_hsf.models.entity_models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`flower_category`")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlowerCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "`flower_id`")
    Flower flower;

    @ManyToOne
    @JoinColumn(name = "`category_id`")
    Category category;

}
