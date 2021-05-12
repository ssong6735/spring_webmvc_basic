package com.spring.mvc.web.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
public class ModifyBoard {

    private int boardNo; // 글번호
    private String writer; // 작성자
    private String title; // 글제목
    private String content; // 글내용

}
