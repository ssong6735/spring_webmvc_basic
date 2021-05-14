package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.score.domain.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    void insertArticleTest() {

        Board board = new Board();
        board.setWriter("김나나");
        board.setTitle("게시판 프로그램 테스트중");
        board.setContent("test ==========================");

        mapper.insertArticle(board);

    }

    @Test
    void deleteArticleTest() {
        mapper.deleteArticle(3);
    }

    @Test
    void getArticlesTest() {
        List<Board> list = mapper.getArticles();

        System.out.println("=================================================================");
        for (Board board : list) {
            System.out.println(board);
        }
        System.out.println("=================================================================");
    }

    @Test
    void getContentTest() {
        Board board = mapper.getContent(1);
        System.out.println("=================================================================");
        System.out.println("board = " + board);
        System.out.println("=================================================================");
    }

    @Test
    void modifyArticleTest() {
        Board board = new Board();
        board.setWriter("수정테스트");
        board.setTitle("게시판 프로그램 테스트중ㄷ5ㄱ45");
        board.setContent("test ==========================");

        board.setBoardNo(2);
        mapper.modifyArticle(board);
    }


}