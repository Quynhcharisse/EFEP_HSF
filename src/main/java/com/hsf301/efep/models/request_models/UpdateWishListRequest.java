package com.hsf301.efep.models.request_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateWishListRequest {
    int wishListItemId;
    int newQty;
}
