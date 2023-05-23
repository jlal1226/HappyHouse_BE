package com.ssafy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.domain.interest.InterestSaleDTO;
import com.ssafy.domain.interest.InterestSaleInfo;
import com.ssafy.domain.user.User;
import com.ssafy.service.InterestSaleService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/interest")
@RestController
@Slf4j
public class InterestSaleController {
    public static final Logger logger = LoggerFactory.getLogger(InterestSaleInfo.class);
    @Autowired
    InterestSaleService interestSaleService;

    @PostMapping("/insert")
    int insertInterest(@RequestBody Map<String, Object> params){
        if (params.get("userInfo") == null) return 0;
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(params.get("userInfo"), User.class);
        String aptCode = mapper.convertValue(params.get("aptCode"), String.class);
        String userId = user.getUserId();
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("aptCode", aptCode);
        return interestSaleService.insertInterest(dealUserMap);
    }

    @DeleteMapping("/delete/")
    int deleteInterest(@RequestBody Map<String, Object> params) {
        if (params.get("userInfo") == null) return 0;
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(params.get("userInfo"), User.class);
        String aptCode = mapper.convertValue(params.get("aptCode"), String.class);
        String userId = user.getUserId();
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("aptCode", aptCode);
        return interestSaleService.deleteInterest(dealUserMap);
    }

    @PostMapping("/list")
    List<InterestSaleInfo> getUserInterestList(@RequestBody User userInfo) {
        if (userInfo == null) return null;
        String userId = userInfo.getUserId();
        List<InterestSaleInfo> list = interestSaleService.getUserInterestList(userId);
        return list;
    }

    @PostMapping("/getInterests")
    List<InterestSaleDTO> getInterests(@RequestBody User userInfo){
        if (userInfo == null) return null;
        String userId = userInfo.getUserId();
        logger.info(userInfo.toString());
        List<InterestSaleDTO> list = interestSaleService.getInterests(userId);
        return list;
    }
}