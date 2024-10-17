package com.hsf301.efep.models.entity_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "`flower_category`")
public class FlowerCategogy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "`flower_id`")
    private Flower flower;

    @ManyToOne
    @JoinColumn(name = "`category_id`")
    private Category category;

}
