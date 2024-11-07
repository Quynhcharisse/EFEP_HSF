package com.hsf301.efep.models.response_models;

import com.hsf301.efep.models.entity_models.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetFlowerDetailResponse {
    String status;
    String message;
    FlowerDetail flowerDetail;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class FlowerDetail {
        String name;
        float price;
        String description;
        int flowerAmount;
        String img;
        int qty;
        int soldQty;
        String status;
        Category category;
    }
}
