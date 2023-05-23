package com.ssafy.service;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;
import com.ssafy.domain.SearchDTO;
import com.ssafy.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<RegionDTO> getRegions(){
    	return homeMapper.getRegions();
    }

    @Override
    public List<HouseSearchResponseDTO> getList(SearchDTO search) throws Exception{
        return homeMapper.getList(search);
    }

    @Override
    public List<HouseDeal> getDealList(String aptCode) throws Exception{
        return homeMapper.getDealList(aptCode);
    }

}
