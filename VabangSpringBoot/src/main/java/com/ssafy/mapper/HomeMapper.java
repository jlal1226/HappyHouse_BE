package com.ssafy.mapper;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;
import com.ssafy.domain.SearchDTO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeMapper {

    List<HouseSearchResponseDTO> getList(SearchDTO search);
    List<RegionDTO> getRegions();

    List<HouseDeal> getDealList(String aptCode);
}
