package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.common.paging.Criteria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    @DisplayName("300개의 게시글을 등록해야 한다.")
    void bulkInsert() {
        for (int i = 1; i <= 300 ; i++) {
            Board board = new Board();
            board.setTitle("테스트제목" + i);
            board.setContent("테스트 내용입니다." + i);
            board.setWriter("USER" + i);

            boardMapper.insertArticle(board);
        }
    }

    @Test
    @DisplayName("페이지 정보에 따른 게시물을 조회해야 한다.")
    void pagingTest1() {
        System.out.println("====================================================================");
        Criteria criteria = new Criteria(1, 10);
        for (Board article : boardMapper.getArticles(criteria)) {
            System.out.println(article);
        }
        System.out.println("====================================================================");
    }

    /*

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

    */

    @Test
    @DisplayName("제목으로 검색된 게시물 리스트를 반환해야 한다.")
    void searchByTitleTest() {
        Criteria criteria = new Criteria();
        criteria.setPage(1);
        criteria.setAmount(10);
        criteria.setKeyword("멍멍");
        criteria.setType("writer");

        System.out.println("==============================================================");
        for (Board searchArticle : boardMapper.getSearchArticles(criteria)) {
            System.out.println(searchArticle);
        }
        System.out.println("==============================================================");
    }



    }