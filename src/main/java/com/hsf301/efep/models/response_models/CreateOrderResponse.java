package com.hsf301.efep.models.response_models;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderResponse {

    private String status;

    private String message;

    private String type;

    private Integer id;

    private String nameBuyer;

    private LocalDateTime createdDate;

    private float totalPrice;

    private String statusOrder;

    private List<OrderDetail> orderDetailList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class OrderDetail {

        private int flowerId;

        private String flowerName;

        private int quantity;

        private float price;
    }

}
