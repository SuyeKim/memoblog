package com.sparta.memoblog.dto;

import com.sparta.memoblog.entity.Memo;
import com.sparta.memoblog.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostPutResponseDto {
    private Long id;
    private final LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String title;
    private String username;
    private String content;

    public PostPutResponseDto(Memo entity) {
        this.id = entity.getId();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
        this.title = entity.getTitle();
        this.username = entity.getUsername();
        this.content = entity.getContent();
    }

}