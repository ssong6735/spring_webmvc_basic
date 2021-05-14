package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.score.domain.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

// 스프링에게 빈을 주입 받으려면
@SpringBootTest
class JdbcBoardRepositoryTest {

    @Autowired
    @Qualifier("bjr")
    private BoardRepository repository;

    @Test
    void insertArticleTest() {

        Board board = new Board();
        board.setWriter("jdbc");
        board.setTitle("jdbc test");
        board.setContent("dadsfkljkasd");

        repository.insertArticle(board);
    }

    @Test
    void modifyArticleTest() {
        Board board = new Board();
        board.setWriter("수정 ");
        board.setTitle("수정 test");
        board.setContent("ㅁㄴㅇㄻㅇㅎfkljkasd");
        board.setBoardNo(8);

        repository.modifyArticle(board);
    }


}