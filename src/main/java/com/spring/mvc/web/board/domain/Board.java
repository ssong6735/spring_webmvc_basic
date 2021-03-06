package com.spring.mvc.web.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
    private Date regDate; // 등록시간

    // 신규 게시물 여부
    private boolean newArticle;

    // 첨부파일 경로 리스트
    private List<String> filePathList;

    public Board() {
        this.boardNo = ++sequence;
    }

    public Board(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
    }

    //조회수 상승처리
    public void upViewCount() {
        this.viewCnt++;
    }

}
