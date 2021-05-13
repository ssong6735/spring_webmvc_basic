CREATE SEQUENCE SEQ_SCORE;

CREATE TABLE score (
    stu_num NUMBER(10),
    stu_name VARCHAR2(20) NOT NULL,
    kor NUMBER(3) NOT NULL,
    eng NUMBER(3) NOT NULL,
    math NUMBER(3) NOT NULL,
    total NUMBER(3),
    avarage NUMBER(5, 2), -- 100.00 (소수점 두자리까지)
    CONSTRAINT pk_score PRIMARY KEY (stu_num)
);

SELECT * FROM score;

-- ALTER TABLE score RENAME COLUMN avarage TO average;

