package com.spring.mvc.web.score.repository;

import com.spring.mvc.web.score.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 마이바티스 SQL 인터페이스
@Mapper // 이 인터페이스와 resources 밑에 있는 xml 과 연동
public interface ScoreMapper {

    // 점수 저장 기능
    void save(Score score);

    // 점수 정보 삭제 기능
    void remove(int stuNum);

    // 개별 점수 조회 기능
    Score findOne(int stuNum);

    // 전체 정보 조회 기능
    List<Score> findAll();

    // 총 성적정보 수 조회 기능 (DB 조회 결과 건수)
    int getCount();

}
