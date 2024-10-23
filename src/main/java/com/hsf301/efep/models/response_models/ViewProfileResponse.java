package com.hsf301.efep.models.response_models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewProfileResponse {

    private String status;

    private String message;
    
    private String type;

    private int id;

    private String name;

    private String phone;

}
