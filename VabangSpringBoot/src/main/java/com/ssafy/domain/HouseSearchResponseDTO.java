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

    String avgDealAmount;
    String avgArea;
    String maxFloor;
    String aptCode;
    String lat;
    String lng;
    String apartmentName;
    String address;
}
