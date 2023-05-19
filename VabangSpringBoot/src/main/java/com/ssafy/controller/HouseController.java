package com.ssafy.controller;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;
import com.ssafy.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/")
@RestController
@CrossOrigin("*")
public class HouseController {

    @Autowired
    HomeService homeService;

    @GetMapping(value ="/list/{keyword}")
    public List<HouseSearchResponseDTO> getList(@PathVariable String keyword) throws Exception{
        Map<String, String> keywordMap = new HashMap<>();
        keywordMap.put("keyword", keyword);
        List<HouseSearchResponseDTO> houseInfos = homeService.getHouseSearchResponses(keywordMap);
        return houseInfos;
    }
    
    @GetMapping(value = "/allregion")
    public List<RegionDTO> getRegions() throws Exception {
    	List<RegionDTO> regions = homeService.getRegions();
    	return regions;
    }

    @PostMapping(value = "/search/")
    public List<HouseSearchResponseDTO> getList(@RequestBody RegionDTO region) throws Exception {
        List<HouseSearchResponseDTO> houseInfos = homeService.searchHouseByRegion(region);
        return houseInfos;
    }

    @GetMapping(value = "/deallist/{aptcode}")
    public List<HouseDeal> getDealList(@PathVariable String aptcode) throws Exception{
        List<HouseDeal> dealList = homeService.getDealList(aptcode);
        return dealList;
    }

}
