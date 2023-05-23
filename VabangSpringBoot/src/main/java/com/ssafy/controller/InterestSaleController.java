package com.ssafy.controller;

import com.ssafy.domain.interest.InterestSaleDTO;
import com.ssafy.domain.interest.InterestSaleInfo;
import com.ssafy.domain.user.User;
import com.ssafy.service.InterestSaleService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/interest")
@RestController
public class InterestSaleController {

    @Autowired
    InterestSaleService interestSaleService;

    @PostMapping("/insert")
    int insertInterest(@RequestBody String aptCode, @RequestBody User user){
        if (user == null) return 0;
        String userId = user.getUserId();
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("aptCode", aptCode);
        return interestSaleService.insertInterest(dealUserMap);
    }

    @DeleteMapping("/delete/{aptCode}")
    int deleteInterest(@PathVariable String aptCode, @RequestBody User user) {
        if (user == null) return 0;
        String userId = user.getUserId();
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("aptCode", aptCode);
        return interestSaleService.deleteInterest(dealUserMap);
    }

    @PostMapping("/list")
    List<InterestSaleInfo> getUserInterestList(@RequestBody User user) {
        if (user == null) return null;
        String userId = user.getUserId();
        List<InterestSaleInfo> list = interestSaleService.getUserInterestList(userId);
        return list;
    }

    @PostMapping("/getInterests")
    List<InterestSaleDTO> getInterests(@RequestBody User user){
        if (user == null) return null;
        String userId = user.getUserId();
        List<InterestSaleDTO> list = interestSaleService.getInterests(userId);
        return list;
    }
}