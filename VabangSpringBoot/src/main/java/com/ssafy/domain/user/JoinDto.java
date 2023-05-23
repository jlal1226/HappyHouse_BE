package com.ssafy.domain.user;


import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    String userId;
    String password;
    String username;
    String address;
    String phone;
}
