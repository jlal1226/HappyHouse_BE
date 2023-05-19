package com.ssafy.service;

import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.InterestSaleInfo;
import java.util.List;
import java.util.Map;

public interface HomeService {

    List<HouseSearchResponseDTO> getHouseSearchResponses(Map<String, String> keywordMap) throws Exception;

}
