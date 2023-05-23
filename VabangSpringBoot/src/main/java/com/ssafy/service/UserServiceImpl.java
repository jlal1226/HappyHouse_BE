package com.ssafy.service;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;
import com.ssafy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User loginProcess(LoginDto dto) throws Exception{
        return mapper.login(dto);
    }

    @Override
    public int join(JoinDto dto) {
        return mapper.join(dto);
    }

    @Override
    public User findUserByUserId(String userId) throws Exception {
        return mapper.findUserByUserId(userId);
    }

    @Override
    public int delete(String userId) {
        return mapper.delete(userId);
    }

    @Override
    public int modify(UserModifyRequestDto dto) {
        return mapper.modify(dto);
    }

    @Override
    public void saveRefreshToken(String userid, String refreshToken) {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", userid);
        map.put("token", refreshToken);
        mapper.saveRefreshToken(map);
    }

    @Override
    public Object getRefreshToken(String userid) {
        return mapper.getRefreshToken(userid);
    }

    @Override
    public void deleteRefreshToken(String userid) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", userid);
        map.put("token", null);
        mapper.deleteRefreshToken(map);

    }
}
