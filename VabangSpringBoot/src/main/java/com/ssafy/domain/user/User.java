package com.ssafy.domain.user;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    String userId;
    String password;
    String role;
    String name;
    String phone;
    String address;
    String joinDate;
}
