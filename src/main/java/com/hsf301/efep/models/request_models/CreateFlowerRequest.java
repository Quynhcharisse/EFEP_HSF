package com.hsf301.efep.models.request_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFlowerRequest {

    private int accountId;

    private String name;

    private Float price;

    private String description;

    private Integer flowerAmount;

    private Integer quantity;

}
