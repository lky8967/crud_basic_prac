package com.example.crud_basic_prac.user;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private String username;
    private String password;
    private String passwordCk;
    private String email;
    private String nickname;
}
