package com.spring.mvc.web.board.service;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.repository.BoardMapper;
import com.spring.mvc.web.common.paging.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional // 트랜잭션 처리 자동화
    public void insertArticle(Board article) throws Exception {
        boardRepository.insertArticle(article);

        // 만약에 첨부파일이 존재한다면 추가 쿼리를 동작해야 함
        List<String> filePathList = article.getFilePathList();
        if (filePathList != null) {
            for (String path : filePathList) {
                boardRepository.addFile(path);
            }
        }
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
    public void modifyArticle(Board article) throws Exception {
        boardRepository.modifyArticle(article);
    }

}