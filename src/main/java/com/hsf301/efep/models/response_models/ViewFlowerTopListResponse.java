package com.hsf301.efep.models.response_models;

import com.hsf301.efep.models.entity_models.Flower;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewFlowerTopListResponse {

    private String status;

    private String message;

    private String type;

    private List<Flower> flowerList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Flower{

        private int id;

        private String name;

        private float price;

        private List<Image> imageList;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Image {

        private String link;
    }
}
