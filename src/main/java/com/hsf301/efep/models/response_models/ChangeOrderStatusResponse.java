package com.hsf301.efep.models.response_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeOrderStatusResponse {

    private String status;

    private String message;

    private String type;

    private ChangedStatus order;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ChangedStatus {
        private int id;
        private String status;
    }
}
