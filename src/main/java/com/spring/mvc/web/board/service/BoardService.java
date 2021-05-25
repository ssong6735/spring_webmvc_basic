package com.spring.mvc.web.board.service;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.repository.BoardMapper;
import com.spring.mvc.web.board.repository.BoardRepository;
import com.spring.mvc.web.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor //mapper 적용시
public class BoardService {

    //public final BoardRepository boardRepository;
    private final BoardMapper boardRepository; //mapper 적용시

    /*@Autowired
    public BoardService(@Qualifier("bjr") BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }*/

    //게시글 목록 가져오기 (제일 오래된 글이 0번 인덱스에 오는것을 역순정렬)
    public List<Board> getArticles(Criteria criteria) {
        /*List<Board> temp = boardRepository.getArticles();
        List<Board> articles = new ArrayList<>();
        for (int i = temp.size() - 1; i >= 0; i--) {
            Board board = temp.get(i);
            articles.add(board);
        }
        return articles;*/
        // 페이징 추가
        // return boardRepository.getArticles(criteria);
        // 검색 쿼리
        return boardRepository.getSearchArticles(criteria);
    }

    // 총 게시물 수 확인
    public int getTotal(Criteria criteria) {
        return boardRepository.getTotalCount(criteria);
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
        // vf="true"일때(정상적인 접근루트: 게시글 클릭)만 조회수 상승
        if (viewFlag) {
            //content.upViewCount(); //조회수상승 memory
            boardRepository.upViewCnt(boardNo); //mapper 적용시
        }
        return content;
    }

    //게시글 수정
    public void modifyArticle(Board article) {
        boardRepository.modifyArticle(article);
    }

}