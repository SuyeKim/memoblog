package com.sparta.memoblog.dto;

import com.sparta.memoblog.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String title;
    private String author;
    private String content;

    public MemoResponseDto(Memo entity) {
        this.id = entity.getId();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
        this.title = entity.getTitle();
        this.author = entity.getUsername();
        this.content = entity.getContents();
    }
}

//다시 공부..하기
