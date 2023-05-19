package com.ssafy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InterestSaleInfo {
    String houseDealNo;//-> houseDeal에서
    String apartmentName;//-> houseInfo에서
    String address;//dongcode에서
    String dealAmount;//houseDeal에서
    String floor;//houseDeal
    String area;//houseDeal
}
