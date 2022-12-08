package com.sparta.memoblog.dto;

import com.sparta.memoblog.entity.User;
import lombok.*;

@Setter
@Getter
public class LoginRequestDto {
    private String username;
    private String password;
}