package com.ssafy.service;

import com.ssafy.domain.interest.InterestSaleDTO;
import com.ssafy.domain.interest.InterestSaleInfo;

import java.util.List;
import java.util.Map;

public interface InterestSaleService {
    int insertInterest(Map<String, String> dealUserMap);
    int deleteInterest(Map<String, String> dealUserMap);
    List<InterestSaleInfo> getUserInterestList(String userId);

    List<InterestSaleDTO> getInterests(String userId);
}
