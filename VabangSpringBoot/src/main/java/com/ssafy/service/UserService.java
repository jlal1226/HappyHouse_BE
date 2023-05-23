package com.ssafy.service;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;

import java.sql.SQLException;

public interface UserService {
    User loginProcess(LoginDto dto) throws Exception;

    int join(JoinDto dto);

    User findUserByUserId(String userId) throws Exception;

    int delete(String userId);

    int modify(UserModifyRequestDto dto);

    public void saveRefreshToken(String userid, String refreshToken);
    public Object getRefreshToken(String userid);
    public void deleteRefreshToken(String userid);

}
