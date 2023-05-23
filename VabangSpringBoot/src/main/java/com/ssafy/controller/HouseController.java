package com.ssafy.controller;

import com.ssafy.domain.HouseDeal;
import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.domain.RegionDTO;
import com.ssafy.domain.SearchDTO;
import com.ssafy.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/deal")
@RestController
@CrossOrigin("*")
public class HouseController {

    @Autowired
    HomeService homeService;

    @GetMapping(value = "/allregion")
    public List<RegionDTO> getRegions() throws Exception {
    	List<RegionDTO> regions = homeService.getRegions();
    	return regions;
    }

    @PostMapping(value = "/search/")
    public List<HouseSearchResponseDTO> getList(@RequestBody SearchDTO search) throws Exception {
        List<HouseSearchResponseDTO> houseInfos = homeService.getList(search);
        return houseInfos;
    }

    @GetMapping(value = "/deallist/{aptcode}")
    public List<HouseDeal> getDealList(@PathVariable String aptcode) throws Exception{
        List<HouseDeal> dealList = homeService.getDealList(aptcode);
        return dealList;
    }

}
