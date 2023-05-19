package com.ssafy.mapper;

import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.InterestSaleInfo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterestSaleMapper {
    int insertInterest(Map<String, String> dealUserMap);
    int deleteInterest(Map<String, String> dealUserMap);
    List<InterestSaleInfo> showInterests(String userId);
}
