package com.spring.mvc.web.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@AllArgsConstructor
@ToString
public class Board {

    // 순차적인 게시글 번호 부여 필드
    public static int sequence;

    private int boardNo; // 글번호
    private String writer; // 작성자
    private String title; // 글제목
    private String content; // 글내용
    private int viewCnt; //조회수

    public Board() {
        this.boardNo = ++sequence;
    }

    public Board(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    //조회수 상승처리
    public void upViewCount() {
        this.viewCnt++;
    }

}
