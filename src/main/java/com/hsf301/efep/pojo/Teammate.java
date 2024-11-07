package com.quynh.efep_hsf.pojo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teammate {
    String image;
    String name;
    String role;
}
