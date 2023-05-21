package com.ssafy.domain.user;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String userId;
    String password;
    String role;
    String username;
    String phone;
    String address;
    String join_date;
}
