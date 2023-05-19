package com.ssafy.service;

import com.ssafy.domain.InterestSaleInfo;
import com.ssafy.mapper.InterestSaleMapper;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestSaleServiceImpl implements InterestSaleService{

    @Autowired
    private InterestSaleMapper interestSaleMapper;

    @Override
    public int insertInterest(Map<String, String> dealUserMap){
        return interestSaleMapper.insertInterest(dealUserMap);
    }

    @Override
    public int deleteInterest(Map<String, String> dealUserMap){
        return interestSaleMapper.deleteInterest(dealUserMap);
    }

    @Override
    public List<InterestSaleInfo> showInterests(String userId){
        return interestSaleMapper.showInterests(userId);
    }

}
