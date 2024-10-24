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
public class ViewSlideBarResponse {

    private String status;

    private String message;

    private String type;

    private List<String> imageList;

}
