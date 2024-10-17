package com.hsf301.efep.models.entity_models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`category`")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy =  "category")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<FlowerCategogy> flowerCategogyList;

}
