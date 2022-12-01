package com.sparta.memoblog.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private long id;
    private String username;
    private String contents;
    private String title;
    private String password;
}
//client에서 넘어오는 username과 contents,title, password를 dto에서 받음

