package com.spring.mvc.web.api.v2;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // API 를 만들때 사용하는 컨트롤러 아노테이션 (spring v4부터 사용)
@RequestMapping("/api/v2")
public class ApiControllerV2 {

    /*
        # ResponseEntity
        - 스프링 REST API 가 응답을 할 때
        응답 상태코드, 응답 헤더 등을 조작해서
        전송할 수 있게 도와주는 객체
     */


    @GetMapping("/hello")
    public ResponseEntity<String> hello(String p) {
        if(p.equals("hello")) { // http 상태코드 응답 조작
            return new ResponseEntity<>("하이하이", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("페이지를 찾을 수 없음.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/hobby")
    public String[] hobby() {
        return new String[] {"음악감상", "축구", "꽃꽂이"};
    }

    @GetMapping("/major")
    public List<String> major() {
        return Arrays.asList("정보보안", "컴퓨터공학", "경영학", "수학과");
    }

    @GetMapping("/board")
    public Board board() {
        return new Board(105, "김레스트", "레스트 api 학습중", "안녕하세요 (ㅇㅅㅇ)//", 0);
    }

    @GetMapping("/food")
    public Map<String, String> food() {
        Map<String, String> foodMap = new HashMap<>();
        foodMap.put("한식", "비빔밥");
        foodMap.put("양식", "피자");
        foodMap.put("중식", "짬뽕");
        return foodMap;
    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/board-list")
    public List<Board> list() {
        return boardService.getArticles();
    }




}
