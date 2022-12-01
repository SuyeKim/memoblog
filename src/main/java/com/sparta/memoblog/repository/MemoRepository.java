package com.sparta.memoblog.repository;


import com.sparta.memoblog.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {


    Optional<Memo> findByIdAndPassword(Long id, String password);
    Boolean existsByIdAndPassword(Long id, String password);

    //내림차순 코드

    List<Memo> findAllByOrderByCreatedAtDesc();
}