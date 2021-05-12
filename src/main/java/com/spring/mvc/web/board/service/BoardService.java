package com.spring.mvc.web.board.service;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BoardService {

    public final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //게시글 목록 가져오기
    public List<Board> getArticles() {
        List<Board> temp = boardRepository.getArticles();
        List<Board> articles = new ArrayList<>();
        for (int i = temp.size() - 1; i >= 0; i--) {
            Board board = temp.get(i);
            articles.add(board);
        }
        return articles;
    }

    //게시글 등록
    public void insertArticle(Board article) {
        boardRepository.insertArticle(article);
    }

    //게시글 삭제
    public void deleteArticle(int boardNo) {
        boardRepository.deleteArticle(boardNo);
    }

    //게시글 내용보기
    public Board getContent(int boardNo, boolean viewFlag) {
        Board content = boardRepository.getContent(boardNo);
        if (viewFlag) {
            content.upViewCount(); //조회수상승
        }
        return content;
    }

    //게시글 수정
    public void modifyArticle(Board article) {
        boardRepository.modifyArticle(article);
    }

}