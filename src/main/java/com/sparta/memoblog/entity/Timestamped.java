package com.sparta.memoblog.entity;

import lombok.Getter; //Lombok이란 어노테이션 기반으로 코드를 자동완성 해주는 라이브러리이다.
// Lombok을 이용하면 Getter, Setter, Equlas, ToString 등과 다양한 방면의 코드를 자동완성 시킬 수 있다.
import org.springframework.data.annotation.CreatedDate;  //@CreatedDate 생성 시 저절로 생김
import org.springframework.data.annotation.LastModifiedDate;  //@LastModifiedDate 생성 시 저절로 생김
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass

@EntityListeners(AuditingEntityListener.class)
public class Timestamped {

    @CreatedDate //데이터 저장 시 '생성된 시간 정보'
    private LocalDateTime createdAt; // LocalDateTime = 날짜와 시간 정보 모두가 필요할 때 사용.

    @LastModifiedDate //데이터 저장 시 '수정된 시간 정보'
    private LocalDateTime modifiedAt; //LocalDateTime = 날짜와 시간 정보 모두가 필요할 때 사용.

}