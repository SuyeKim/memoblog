package com.sparta.memoblog.dto;

import lombok.Getter;

@Getter
public class MemoDeleteResponseDto {
    private Boolean success;

    public  MemoDeleteResponseDto(Boolean result){
        this.success = result;
    }
}
//공부를 다시..하자
