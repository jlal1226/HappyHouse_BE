package com.ssafy.domain.user;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String id;
    String userId;
    String password;
    String username;
    String address;
    String role;
}
