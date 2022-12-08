package com.sparta.memoblog.repository;

import com.sparta.memoblog.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long>{
    List<Memo> findAllByOrderByCreatedAtDesc();

//    Optional<Memo> findByIdAndPassword(Long id, String password);
//    Boolean existsByIdAndPassword(Long id, String password);  //?
}