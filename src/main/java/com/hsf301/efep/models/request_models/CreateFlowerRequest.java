package com.quynh.efep_hsf.models.request_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateFlowerRequest {
    String name;
    float price;
    int quantity;
    int flowerAmount;
    String description;
    int categoryId;
}
