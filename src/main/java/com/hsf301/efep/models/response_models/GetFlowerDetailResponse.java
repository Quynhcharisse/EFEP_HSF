package com.hsf301.efep.models.response_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetFlowerDetailResponse {
    String status;
    String message;
}