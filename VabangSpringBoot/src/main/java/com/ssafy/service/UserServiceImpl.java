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
    public int join(User user) {
        return mapper.join(user);
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
    public int modify(User user) throws Exception{
        return mapper.modify(user);
    }

    @Override
    public void saveRefreshToken(String userId, String refreshToken) {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("token", refreshToken);
        mapper.saveRefreshToken(map);
    }

    @Override
    public Object getRefreshToken(String userId) {
        return mapper.getRefreshToken(userId);
    }

    @Override
    public void deleteRefreshToken(String userId) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("userid", userId);
        map.put("token", null);
        mapper.deleteRefreshToken(map);

    }
}
