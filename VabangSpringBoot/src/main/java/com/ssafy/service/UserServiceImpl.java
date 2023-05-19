package com.ssafy.service;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;
import com.ssafy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User loginProcess(LoginDto dto) {
        return mapper.login(dto);
    }

    @Override
    public int join(JoinDto dto) {
        return mapper.join(dto);
    }

    @Override
    public int findUserByUserId(String userId) {
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
}
