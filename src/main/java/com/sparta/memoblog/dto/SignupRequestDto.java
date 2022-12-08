package com.sparta.memoblog.dto;

import lombok.*;

import javax.validation.constraints.*;


@Setter
@Getter
public class SignupRequestDto  {
    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    @Pattern(regexp = "^[A-Za-z0-9]{8,15}$")
    private String password;
}