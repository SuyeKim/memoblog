package com.sparta.memoblog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostPutRequestDto {
    private String title;

    private String content;
}