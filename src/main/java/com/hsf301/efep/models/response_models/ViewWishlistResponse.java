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
public class ViewWishlistResponse {

    private String status;

    private String message;

    private String type;

    private int id;

    private int userId;

    private String userName;

    private List<WishlistItems> wishlistItemList;

    private float totalPrice;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class WishlistItems {
        private int id;
        private String name;
        private int quantity;
        private float price;
    }

}
