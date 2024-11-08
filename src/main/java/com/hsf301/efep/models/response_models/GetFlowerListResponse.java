package com.hsf301.efep.models.response_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetFlowerListResponse {
    String status;
    String message;
    int currentPage;
    int totalPages;
    long totalElements;
    int minPrice;
    int maxPrice;
    String keyword;
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
