package com.quynh.efep_hsf.models.response_models;

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
    List<Flower> flowers;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Flower {
        int id;
        String name;
        float price;
        String img;
    }
}
