CREATE SEQUENCE seq_board;

CREATE TABLE board (
    board_no NUMBER(10),
    writer VARCHAR2(20) NOT NULL,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000),
    view_cnt NUMBER(10) DEFAULT 0,
    CONSTRAINT pk_board PRIMARY KEY (board_no)
);

SELECT * FROM board ORDER BY board_no DESC;


/*
SELECT
    board_no, writer, title, content
FROM (SELECT /*+INDEX_DESC(board pk_board)*/
        rownum rn, board_no, writer, title, content
    FROM board
    WHERE rownum <= 10)
WHERE rn > 0
;
*/