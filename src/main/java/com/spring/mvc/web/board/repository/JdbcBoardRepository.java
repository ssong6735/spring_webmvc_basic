package com.spring.mvc.web.board.repository;

import com.spring.mvc.web.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("bjr")
@RequiredArgsConstructor // 자동주입용 생성자 적는 대신 넣어주기
public class JdbcBoardRepository implements BoardRepository {

    // 스프링 JDBC 가 제공하는 jdbc 템플릿
    private final JdbcTemplate template;

    @Override
    public List<Board> getArticles() {
        String sql = "SELECT * FROM board ORDER BY board_no";
        return template.query(sql, new JdbcBoardRepository.BoardMapper());
    }

    @Override
    public void insertArticle(Board article) {
        String sql = "INSERT INTO board VALUES " +
                "(seq_board.nextval, ?, ?, ?, ?)";
        template.update(sql, article.getWriter(), article.getTitle(), article.getContent(), article.getViewCnt());
    }

    @Override
    public void deleteArticle(int boardNo) {
        String sql = "DELETE FROM board WHERE board_no = ?";
        template.update(sql, boardNo);
    }

    @Override
    public Board getContent(int boardNo) {
        String sql = "SELECT * FROM board WHERE board_no = ?";
        return template.queryForObject(sql, new JdbcBoardRepository.BoardMapper(), boardNo);
    }

    @Override
    public void upViewCnt(int boardNo, int viewCnt) {
        String sql = "UPDATE board SET view_cnt = view_cnt + 1 WHERE board_no = ?";
        template.update(sql, boardNo, viewCnt);
    }

    @Override
    public void modifyArticle(Board article) {
        String sql = "UPDATE board SET " +
                "writer = ?, title = ?, content = ? " +
                "WHERE board_no = ?";
        template.update(sql, article.getWriter(), article.getTitle(), article.getContent(), article.getBoardNo());

    }

    // 내부 클래스 (inner class) : JdbcBoardRepository 에서만 사용할 전용 클래스
    class BoardMapper implements RowMapper<Board> {

        @Override
        public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Board(rs);
        }
    }
}
