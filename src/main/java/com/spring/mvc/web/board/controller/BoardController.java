package com.spring.mvc.web.board.controller;

import com.spring.mvc.web.board.domain.Board;
import com.spring.mvc.web.board.domain.ModifyBoard;
import com.spring.mvc.web.board.service.BoardService;
import com.spring.mvc.web.common.paging.Criteria;
import com.spring.mvc.web.common.paging.PageMaker;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //글 작성 화면 요청
    @GetMapping("/board/write")
    public String write(HttpSession session) {

        /*// 로그인 세션 검증
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/member/sign-in";
        }*/

        return "board/b_write";
    }

    //글 작성 처리 요청
    @PostMapping("/board/write")
    public String write(Board article) {
        try {
            log.info("/board/write POST: " + article);

            List<String> files = article.getFilePathList();
            log.info(files);

            boardService.insertArticle(article);
        } catch (Exception e) {
            return "/board/b_write";
        }
        return "redirect:/board/list";
    }

    //글 목록 요청
    @GetMapping("/board/list")
    public String list(Criteria criteria, Model model) {
        model.addAttribute("articles", boardService.getArticles(criteria));
        // 페이지 정보를 만들어서 jsp 에게 보내기
        model.addAttribute("pageMaker", new PageMaker(criteria, boardService.getTotal(criteria)));
        return "board/b_list";
    }

    //글 삭제 요청
    @GetMapping("/board/delete")
    public String delete(int boardNo) {
        boardService.deleteArticle(boardNo);
        return "redirect:/board/list";
    }

    //글 상세보기 요청
    @GetMapping("/board/content")
    public String content(int boardNo
            , @RequestParam("vf") boolean viewCntFlag
            , @ModelAttribute("cri") Criteria criteria, Model model) {
        Board content = boardService.getContent(boardNo, viewCntFlag);
        model.addAttribute("article", content);
        //model.addAttribute("cri", criteria);
        return "board/b_content";
    }

    // 글 상세보기 요청에서 첨부파일 경로리스트를 조회하는 비동기 요청
    @GetMapping("/board/file/{boardNo}")
    @ResponseBody
    public ResponseEntity<List<String >> getFilePaths(@PathVariable int boardNo) {
        log.info("/board/file/" + boardNo + "비동기 GET 요청!");
        return new ResponseEntity<>(boardService.getFilePaths(boardNo), HttpStatus.OK);
    }

    //글 수정하기 화면요청
    @GetMapping("/board/modify")
    public String modify(int boardNo
            , @RequestParam("vf") boolean viewCntFlag
            , Model model) {

        model.addAttribute("article", boardService.getContent(boardNo, viewCntFlag));
        return "board/b_modify";
    }

    //글 수정 처리요청
    @PostMapping("/board/modify")
    public String modify(ModifyBoard modArticle
            , @RequestParam("vf") boolean viewCntFlag) {
        // 원본데이터를 찾아서 수정데이터로 변경하는 로직(서비스에 넣어주는게 좋다)
        Board board = boardService.getContent(modArticle.getBoardNo(), viewCntFlag);
        board.setWriter(modArticle.getWriter());
        board.setTitle(modArticle.getTitle());
        board.setContent(modArticle.getContent());
        try {
            boardService.modifyArticle(board);
        } catch (Exception e) {
            return "redirect:/board/content?boardNo=" + modArticle.getBoardNo() + "&vf=false";
        }
        return "redirect:/board/content?boardNo=" + modArticle.getBoardNo() + "&vf=false";
    }
}