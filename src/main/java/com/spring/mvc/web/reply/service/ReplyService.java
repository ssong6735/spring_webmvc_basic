package com.spring.mvc.web.reply.service;

import com.spring.mvc.web.reply.domain.Reply;
import com.spring.mvc.web.reply.repository.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyService {

    // 데이터 전송 확인용 boolean 리턴값 상수 지정
    private static final int SUCCESS = 1;

    private final ReplyMapper replyMapper;

    // 댓글 등록 서비스
    public boolean register(Reply reply) {
        return replyMapper.save(reply) == SUCCESS;
    }

    // 댓글 수정 서비스
    public boolean modify(Reply reply) {
        return replyMapper.update(reply) == SUCCESS;
    }

    // 댓글 삭제 서비스
    public boolean remove(int replyNo) {
        int delete = replyMapper.delete(replyNo);
//        log.info("service delete resultNum: " + delete);
        return  delete == SUCCESS;
    }

    // 개별 댓글 조회 서비스
    public Reply get(int replyNo) {
        return replyMapper.read(replyNo);
    }

    // 댓글 목록 조회 서비스
    public List<Reply> getList(int boardNo) {
        return replyMapper.getList(boardNo);
    }

}
