package com.ssafy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDeal {
    String no;
    String dealAmount;
    String dealYear;
    String dealMonth;
    String dealDay;
    String area;
    String floor;
    String cancelDealType;
    String aptCode;
}
