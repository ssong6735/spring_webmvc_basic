<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>detail.jsp</title>

    <style>
        ul {
            margin-left: 20px;
        }

        li {
            margin-bottom: 10px;
        }

        .btn {
            display: block;
            border: 1px solid #333;
            background: #ccc;
            border-radius: 5px;
            padding: 5px;
            margin: 40px auto 10px;
            text-decoration: none;
            color: #333;
            width: 100px;
            text-align: center;
        }

        .btn:hover {
            background: #333;
            color: #fff;
        }

        .info-box {
            width: 300px;
            margin: 30px auto;
            border: 3px solid skyblue;
            padding: 30px;
        }

        .info-box h1 {
            text-align: center;
        }
    </style>
</head>

<body>

    <div class="info-box">
        <h1>${score.name}님 성적정보</h1>

        <ul>
            <li>국어: ${score.kor}점</li>
            <li>영어: ${score.eng}점</li>
            <li>수학: ${score.math}점</li>
            <li>총점: ${score.total}점</li>
            <li>평균: ${score.average}점</li>
        </ul>

        <a class="btn" href="/score/list">목록보기</a>
    </div>

</body>

</html>