package com.ssafy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseSearchResponseDTO {
    String aptCode;
    String address;
    String lat;
    String lng;
    String apartmentName;
}
