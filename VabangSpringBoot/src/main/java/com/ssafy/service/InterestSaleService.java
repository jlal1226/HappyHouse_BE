package com.ssafy.service;

import com.ssafy.domain.InterestSaleInfo;
import java.util.List;
import java.util.Map;

public interface InterestSaleService {
    int insertInterest(Map<String, String> dealUserMap);
    int deleteInterest(Map<String, String> dealUserMap);
    List<InterestSaleInfo> showInterests(String userId);

}
