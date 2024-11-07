package com.hsf301.efep.models.response_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetCustomerOrderHistoryResponse {
    String status;
    String message;
    List<Order> order;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Order {
        int id;
        LocalDateTime createdDate;
        String status;
        float totalPrice;
    }
}
