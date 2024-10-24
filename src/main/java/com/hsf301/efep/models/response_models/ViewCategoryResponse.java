package com.hsf301.efep.models.response_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewCategoryResponse {

    private String status;

    private String message;

    private String type;

    private List<Category> categoryList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Category {

        private int id;

        private String name;
    }
}
