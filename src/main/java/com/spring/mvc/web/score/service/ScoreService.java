package com.spring.mvc.web.score.service;

import com.spring.mvc.web.score.domain.Score;
import com.spring.mvc.web.score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링에 빈 등록
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(@Qualifier("jr") ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public void register(Score score) {
        score.calcTotalAvg();
        scoreRepository.save(score);
    }

    // 점수 리스트를 받아오는 기능
    public List<Score> getScoreList() {
        return scoreRepository.findAll();
    }

    // 점수 정보 삭제 기능
    public void delete(int stuNum) {
        scoreRepository.remove(stuNum);
    }

    // 학생 점수 정보 보기 기능
    public Score getScore(int stuNum) {
       return scoreRepository.findOne(stuNum);
    }

}
