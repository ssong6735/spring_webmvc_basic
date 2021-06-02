-- 회원 관리 테이블
CREATE TABLE member (
    account VARCHAR2(50),
    password VARCHAR2(150) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(100) NOT NULL UNIQUE,
    auth VARCHAR2(20) DEFAULT 'COMMON',
    reg_date DATE DEFAULT SYSDATE,
    CONSTRAINT pk_member PRIMARY KEY (account)
);

INSERT INTO member (account, password, name, email, auth)
VALUES ('admin', '1234', '관리자', 'admin@gmail.com', 'ADMIN');

COMMIT;

SELECT * FROM member;


-- 회원가입여부 확인 (아이디가 있으면 보이고 없으면 공집합)
SELECT * FROM member
WHERE account = 'admin';



-- 중복체크 쿼리
SELECT COUNT(*) FROM member
WHERE account = 'admin123';
-- '사용자가 가입하려고 하는 아이디';