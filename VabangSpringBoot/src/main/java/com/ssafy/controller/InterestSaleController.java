package com.ssafy.controller;

import com.ssafy.domain.interest.InterestSaleDTO;
import com.ssafy.domain.interest.InterestSaleInfo;
import com.ssafy.service.InterestSaleService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/interest")
@RestController
@CrossOrigin("*")
public class InterestSaleController {

    @Autowired
    InterestSaleService interestSaleService;

    @PostMapping("/insert")
    int insertInterest(@RequestBody String aptCode){//(@SessionAttribute User user, @RequestParam String aptCode){
        /*
        if (user == null) return 0;
        String userId = user.getUserId();
        */
        String userId = "admin";
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("aptCode", aptCode);
        return interestSaleService.insertInterest(dealUserMap);
    }

    @DeleteMapping("/delete/{aptCode}")
    int deleteInterest(@PathVariable String aptCode) {//(@SessionAttribute User user, @RequestParam String aptCode){
        /*
        if (user == null) return 0;
        String userId = user.getUserId();
         */
        String userId = "admin";
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("aptCode", aptCode);
        return interestSaleService.deleteInterest(dealUserMap);
    }

    @GetMapping("/list")
    List<InterestSaleInfo> getUserInterestList() {
        String userId = "admin";
        if (userId == null) return null;

        List<InterestSaleInfo> list = interestSaleService.getUserInterestList(userId);
        System.out.println(list);
        return list;
    }

    @GetMapping("/getInterests")
    List<InterestSaleDTO> getInterests(){
        String userId = "admin";
        if (userId == null) return null;

        List<InterestSaleDTO> list = interestSaleService.getInterests(userId);
        return list;
    }
}