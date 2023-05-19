package com.ssafy.service;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseInfo;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;
import com.ssafy.mapper.HomeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;
import java.rmi.server.ExportException;
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
    
    @Override
    public List<RegionDTO> getRegions() throws Exception {
    	return homeMapper.getRegions();
    }

    @Override
    public List<HouseSearchResponseDTO> searchHouseByRegion(RegionDTO region) throws Exception{
        return homeMapper.searchHouseByRegion(region);
    }
}
