package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bmr") // 스프링에 빈 등록
@Log4j2 // 로그 사용
public class MemoryBoardRepository implements BoardRepository {

    // Board 객체를 저장할 Map 생성 (메모리 DB 역할)
    // key: 글번호, value: 작성자, 글제목, 글내용 객체
    private static Map<Integer, Board> boardMap = new HashMap<>();

    static {
        boardMap.put(1, new Board("김철수", "글제목1", "블라블라"));
        boardMap.put(2, new Board("박영희", "글제목2", "블라블라"));
        boardMap.put(3, new Board("고길동", "글제목3", "블라블라"));
    }

    @Override
    public List<Board> getArticles() {
        List<Board> articles = new ArrayList<>();
        for (int boardNo : boardMap.keySet()) {
            Board board = boardMap.get(boardNo);
            articles.add(board);
        }
        return articles;
    }

    @Override
    public void insertArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
    }

    @Override
    public void deleteArticle(int boardNo) {
        boardMap.remove(boardNo);
    }

    @Override
    public Board getContent(int boardNo) {
        return boardMap.get(boardNo);
    }

    @Override
    public void upViewCnt(int boardNo, int viewCnt) {
        //jdbc 연동시 사용
    }

    @Override
    public void modifyArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
    }
}
