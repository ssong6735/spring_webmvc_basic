package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 마이바티스 SQL 인터페이스
@Mapper // 이 인터페이스와 resources 밑에 있는 xml 과 연동
public interface BoardMapper {

    //게시글 목록 가져오기
    List<Board> getArticles();

    //게시글 등록
    void insertArticle(Board article);

    //게시글 삭제
    void deleteArticle(int boardNo);

    //게시글 내용보기
    Board getContent(int boardNo);

    //조회수 올리기
    void upViewCnt(int viewCnt);

    //게시글 수정
    void modifyArticle(Board article);

}