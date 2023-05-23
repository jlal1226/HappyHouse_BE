package com.ssafy.domain.interest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InterestSaleInfo {
    String aptName;
    String aptCode;
    String avgDealAmount;
    String address;
    String avgArea;
}
