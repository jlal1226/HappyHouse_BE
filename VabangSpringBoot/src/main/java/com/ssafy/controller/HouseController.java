package com.ssafy.controller;

import com.ssafy.domain.HouseSearchResponseDTO;
import com.ssafy.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/myhome")
@RestController
public class HouseController {

    @Autowired
    HomeService homeService;

    @GetMapping(value ="/list/{keyword}")
    public List<HouseSearchResponseDTO> getList(@PathVariable String keyword) throws Exception{
        Map<String, String> keywordMap = new HashMap<>();
        keywordMap.put("keyword", keyword);
        List<HouseSearchResponseDTO> houseInfos = homeService.getHouseSearchResponses(keywordMap);
        System.out.println("asd");
        return houseInfos;
    }


}
