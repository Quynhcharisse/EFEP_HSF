package com.quynh.efep_hsf.models.request_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SortFlowerRequest {
    float price;
    String cateName;
    String sortType;
}
