package com.ssafy.service;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;
import com.ssafy.domain.SearchDTO;

import java.util.List;
import java.util.Map;

public interface HomeService {

    List<HouseSearchResponseDTO> getList(SearchDTO search) throws Exception;
    List<HouseDeal> getDealList(String aptCode) throws Exception;
    List<RegionDTO> getRegions();

}
