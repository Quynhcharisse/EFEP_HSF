package com.hsf301.efep.models.response_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchFlowerResponse {
    String status;
    String message;
    int currentPage;
    int totalPages;
    long totalElements;
    int minPrice;
    int maxPrice;
    List<Flower> flowers;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Flower{
        int id;
        String name;
        float price;
        String img;
    }
}
