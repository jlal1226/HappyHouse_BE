package com.ssafy.mapper;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User login(LoginDto dto);

    int join(JoinDto dto);

    int findUserByUserId(String userId);

    int delete(String userId);

    int modify(UserModifyRequestDto dto);
}
