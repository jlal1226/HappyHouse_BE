package com.ssafy.service;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;

import java.sql.SQLException;

public interface UserService {
    User loginProcess(LoginDto dto) throws Exception;

    int join(User user);

    User findUserByUserId(String userId) throws Exception;

    int delete(String userId) throws Exception;

    int modify(User user) throws Exception;

    public void saveRefreshToken(String userId, String refreshToken);
    public Object getRefreshToken(String userId);
    public void deleteRefreshToken(String userId) throws Exception;

}
