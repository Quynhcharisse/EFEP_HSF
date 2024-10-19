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
public class ViewOrderDetailBuyerResponse {
    private String status;

    private String message;

    private String type;

    private int orderId;

    private float totalPrice;

    private String orderStatus;

    private List<Detail> detailList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Detail {

        private String sellerName;

        private String flowerName;

        private int quantity;

        private float price;
    }
}
