package com.ssafy.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.domain.interest.InterestSaleDTO;
import com.ssafy.domain.interest.InterestSaleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterestSaleMapper {
    int insertInterest(Map<String, String> dealUserMap);
    int deleteInterest(Map<String, String> dealUserMap);

    List<InterestSaleInfo> getUserInterestList(String userId);

    List<InterestSaleDTO> getInterests(String userId);
}
