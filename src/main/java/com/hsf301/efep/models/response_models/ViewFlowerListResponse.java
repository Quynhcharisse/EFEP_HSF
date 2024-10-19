package com.hsf301.efep.models.response_models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewFlowerListResponse {
    private String status;

    private String message;

    private String type;

    private List<Flower> flowerList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Flower {

        private int id;

        private String name;

        private float price;

        private int flower_amount;

        private int quantity;

        private int sold_quantity;
//
//        private List<Image> imageList;
    }

//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Builder
//    public static class Image {
//
//        private String link;
//    }
}
