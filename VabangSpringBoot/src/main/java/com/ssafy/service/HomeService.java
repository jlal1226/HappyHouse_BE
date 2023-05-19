package com.ssafy.service;

import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Map;

public interface HomeService {

    List<HouseSearchResponseDTO> getHouseSearchResponses(Map<String, String> keywordMap) throws Exception;
    List<RegionDTO> getRegions() throws Exception;
    List<HouseSearchResponseDTO> searchHouseByRegion(RegionDTO region) throws Exception;
}
