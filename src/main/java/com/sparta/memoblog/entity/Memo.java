package com.sparta.memoblog.entity;

import com.sparta.memoblog.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter

@Entity //JP하면, DB 테이블에 대응하는 하나의 클래스라고 생각할 수 있습니다.
//@Entity가 붙은 클래스는 JPA가 관리해주며,
// JPA를 사용해서 DB 테이블과 매핑할 클래스는 @Entity를 꼭 붙여야만 매핑이 가능합니다.

@NoArgsConstructor //제일 기본인 생성자 어노테이션이다. 아무 인수가 없는 생성자를 생성해준다.

public class Memo extends Timestamped {
    @Id //데이터베이스 테이블의 기본 키(PK)와 객체의 필드를 매핑시켜주는 어노테이션

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;


    public Memo(MemoRequestDto requestDto, User user) {
        this.username = user.getUsername();
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
        this.user = user;
    }


    public  void update(MemoRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
    }
}