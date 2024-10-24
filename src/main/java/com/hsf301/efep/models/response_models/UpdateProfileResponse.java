package com.hsf301.efep.models.response_models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProfileResponse {
    
    private String status;

    private String message;

    private String type;

    private int id;

    private String name;

    private String phone;

}
