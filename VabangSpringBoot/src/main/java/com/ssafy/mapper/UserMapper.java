package com.ssafy.mapper;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface UserMapper {
    User login(LoginDto dto);

    int join(JoinDto dto);

    int findUserByUserId(String userId);

    int delete(String userId);

    int modify(UserModifyRequestDto dto);

    public void saveRefreshToken(Map<String, String> map);
    public Object getRefreshToken(String userid);
    public void deleteRefreshToken(Map<String, String> map);
}
