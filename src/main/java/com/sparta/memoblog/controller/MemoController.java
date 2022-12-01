package com.sparta.memoblog.controller;

import com.sparta.memoblog.dto.MemoDeleteRequestDto;
import com.sparta.memoblog.dto.MemoDeleteResponseDto;
import com.sparta.memoblog.dto.MemoRequestDto;
import com.sparta.memoblog.dto.MemoResponseDto;
import com.sparta.memoblog.entity.Memo;
import com.sparta.memoblog.repository.MemoRepository;
import com.sparta.memoblog.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoService memoService; //메모 서비스 연결

//    @GetMapping("/") //처음 홈
//    public ModelAndView home() { //객체를 생성해서 데이터를 넣어좀
//        return new ModelAndView("index"); //반환 파일
//    }

    @PostMapping("/api/memos") //게시글 작성
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto); //클라이언트에서 가져온 requestDto 값 사용
    }

    @GetMapping("/api/memos") //전체조회
    public List<Memo> getMemos() {
        return memoService.getMemos(); //메모 서비스에 연결
    }

    //수정
    @PutMapping("/api/memos/{id}") //id값을 보냄 ,반환타입 long
    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    } //값을 받아옴, 어떤 내용을 수정했는지 내용도 받아와야함 ,메모서비스와 연결

    //제거
    @DeleteMapping("/api/post/{id}")  //index파일 deleteOne()에서 "DELETE"방식 "/api/memos"을 가져온 것임.{id}추가 입력
    public MemoDeleteResponseDto deleteMemo(@PathVariable Long id, @RequestBody MemoDeleteRequestDto requestDto) {  //위와 같은 방식으로 service 자바클래스로 가서 만들어준다.
        boolean deleteResult = memoService.deleteMemo(id, requestDto.getPassword());
        return new MemoDeleteResponseDto(deleteResult);
    }
    @GetMapping("/api/post/{id}")  // 선택한 게시글 조회
    public MemoResponseDto getPost(@PathVariable Long id) {
        return memoService.getPost(id);
    }

}
