package com.sparta.memoblog.entity;

import com.sparta.memoblog.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor //JPA 사용하여 DB테이블과 연결할 클래스는 @Entity를 꼭 붙여야함
public class Memo extends Timestamped {
    @Id//pk
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String password;



    //생성자 ->인스턴스 변수값을 초기화 시킴
    //안스턴스 변수와 지역변수를 구별하기 위해서 this(참조변수 )사용
    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
        this.id = requestDto.getId();

    }

    //메서드
    public void update(MemoRequestDto requestDto) {
        //가지고 온 데이터로 수정
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }
}