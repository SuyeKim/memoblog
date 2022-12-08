package com.sparta.memoblog.controller;

import com.sparta.memoblog.dto.*;
import com.sparta.memoblog.jwt.JwtUtil;
import com.sparta.memoblog.repository.MemoRepository;
import com.sparta.memoblog.repository.UserRepository;
import com.sparta.memoblog.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Service
public class MemoController {
    private final MemoService memoService;
    private final UserRepository userRepository;

    private final MemoRepository memoRepository;
    private final JwtUtil jwtUtil;

    //홈
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }


    //메모 생성하기
    @PostMapping("/api/post")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto, HttpServletRequest request) {  //Memo를 바로 반환할 것이기에 Memo라고 해줍니다.

        return memoService.createMemo(requestDto, request);
    }

    //게시글 전체 조회
    @GetMapping("api/post")
    public List<MemoResponseDto> getMemos() {
        return memoService.getMemos();
    }

    // 선택한 게시글 조회
    @GetMapping("/api/post/{id}")
    public MemoResponseDto getPost(@PathVariable Long id) {
        return memoService.getPost(id);
    }

    //선택한 게시글 수정,
    @PutMapping("/api/post/{id}")
    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto, HttpServletRequest request) {  //@requestBody => json 형식 (받을 데이터가 여러개일때)
        return memoService.updateMemo(id, requestDto, request);

    }

    //선택한 게시글 삭제,
    @DeleteMapping("/api/post/{id}")
    public MemoDeleteResponseDto deleteMemo(@PathVariable Long id,  HttpServletRequest request) {
        return  memoService.deleteMemo(id, request);

    }

//        @DeleteMapping("/api/post/{id}")  //선택한 게시글 삭제, index파일 deleteOne()에서 "DELETE"방식 "/api/memos"을 가져온 것임.{id}추가 입력
//        public MemoDeleteResponseDto deleteMemo(@PathVariable Long id, @RequestBody MemoDeleteRequestDto requestDto) {  //위와 같은 방식으로 service 자바클래스로 가서 만들어준다.
//                boolean deleteResult = memoService.deleteMemo(id, requestDto.getPassword());
//                return new MemoDeleteResponseDto(deleteResult);
//        }
}