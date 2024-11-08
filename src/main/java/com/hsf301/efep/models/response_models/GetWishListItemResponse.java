package com.hsf301.efep.models.response_models;

import com.hsf301.efep.models.entity_models.Flower;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetWishListItemResponse {
    String status;
    String message;
    List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Item {
        int id;
        String name;
        int quantity;
        float price;
        Flower flower;
    }
}
