package com.quynh.efep_hsf.models.request_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
<<<<<<<< HEAD:src/main/java/com/hsf301/efep/models/request_models/UpdateWishlistRequest.java
public class UpdateWishListRequest {
    int wishListItemId;
    int newQty;
========
public class DisableFlowerRequest {
    int id;
>>>>>>>> origin/main:src/main/java/com/hsf301/efep/models/request_models/DisableFlowerRequest.java
}
