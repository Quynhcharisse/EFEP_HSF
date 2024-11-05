package com.quynh.efep_hsf.models.response_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetWorkingYearAmountResponse {
    String status;
    String message;
}
