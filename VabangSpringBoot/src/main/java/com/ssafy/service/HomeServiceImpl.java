package com.ssafy.service;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseInfo;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.InterestSaleInfo;
import com.ssafy.mapper.HomeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<HouseSearchResponseDTO> getHouseSearchResponses(Map<String, String> keywordMap) throws Exception {
        return homeMapper.getHouseSearchResponses(keywordMap);
    }

}
