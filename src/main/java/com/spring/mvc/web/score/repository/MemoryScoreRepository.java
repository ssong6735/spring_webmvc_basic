package com.spring.mvc.web.score.repository;

import com.spring.mvc.web.score.domain.Score;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("mr") // 스프링에 빈 등록
@Log4j2 // 로그 사용
public class MemoryScoreRepository implements ScoreRepository {

    // Score 객체를 저장할 Map 생성 (메모리 DB 역할)
    // key: 학번, value: 점수정보 객체
    private static Map<Integer, Score> scoreMap = new HashMap<>();

    static {
        scoreMap.put(1, new Score("김철수", 99, 78, 67));
        scoreMap.put(2, new Score("박영희", 85, 56, 95));
        scoreMap.put(3, new Score("고길동", 100, 88, 92));
    }

    @Override
    public void save(Score score) {
        scoreMap.put(score.getStuNum(), score);
        log.info(scoreMap);
    }

    @Override
    public void remove(int stuNum) {
        scoreMap.remove(stuNum);
    }

    @Override
    public Score findOne(int stuNum) {
        return scoreMap.get(stuNum);
    }

    @Override
    public List<Score> findAll() {
        List<Score> scoreList = new ArrayList<>();

        // map 의 score 객체들을 모두 뽑아 리스트에 담음
        for (int key : scoreMap.keySet()) {
            scoreList.add(scoreMap.get(key));
        }
        return scoreList;
    }
}
