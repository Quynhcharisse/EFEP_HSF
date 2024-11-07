package com.hsf301.efep.models.response_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTopSoldFlowerResponse {

    String status;
    String message;
    List<Flower> flowers;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Flower{
        int id;
        String name;
        float price;
        String img;
    }
}
