package com.ssafy.controller;

import com.ssafy.domain.InterestSaleInfo;
import com.ssafy.service.InterestSaleService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/interest")
@RestController
public class InterestSaleController {

    @Autowired
    InterestSaleService interestSaleService;

    @GetMapping("/show/{userId}")
    public List<InterestSaleInfo> showInterests(@PathVariable String userId) { //@SessionAttribute User user){
       //if (user == null) return null;
       //String userId = user.getId();
       return interestSaleService.showInterests(userId);
    }

    @PostMapping("/insert")
    int insertInterest(@RequestParam("userId") String userId, @RequestParam("dealNo") String dealNo) { //@SessionAttribute User user, @RequestParam String dealNo){
        //if (user == null) return 0;
        //String userId = user.getId();
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("dealNo", dealNo);
        return interestSaleService.insertInterest(dealUserMap);
    }

    @DeleteMapping("/delete")
    int deleteInterest(@RequestParam("userId") String userId, @RequestParam("dealNo") String dealNo) { //@SessionAttribute User user, @RequestParam String dealNo){
        //if (user == null) return 0;
        //String userId = user.getId();
        Map<String, String> dealUserMap = new HashMap<>();
        dealUserMap.put("userId", userId);
        dealUserMap.put("dealNo", dealNo);
        return interestSaleService.deleteInterest(dealUserMap);
    }




}
