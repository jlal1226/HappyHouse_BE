package com.ssafy.mapper;

import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.InterestSaleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeMapper {

    List<HouseSearchResponseDTO> getHouseSearchResponses(Map<String, String> keywordMap);
    int showDealDetail(String homeDealNo);//-> return type 바꿔야됨
}
