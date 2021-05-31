<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 내용 보기</title>

    <style>
        a {
            text-decoration: none;
        }

        .del-btn {
            background: orangered;
            color: #fff;
            border-radius: 5px;
            padding: 2px 5px;
        }

        .btn {
            display: inline-block;
            border: 1px solid #333;
            background: #ccc;
            border-radius: 5px;
            padding: 5px;
            margin: 40px auto 10px;
            text-decoration: none;
            color: #333;
            width: 100px;
            text-align: center;
            font-size: 16px;
        }

        .btn:hover {
            background: #333;
            color: #fff;
        }

        table,
        tr,
        th,
        td {
            border: 1px solid #ccc;
        }

        table {
            width: 500px;
            border-collapse: collapse;
        }

        th {
            width: 10%;
            padding: 5px;
            text-align: center;
            background: #333;
            color: #fff;
        }

        td {
            padding: 5px;
            text-align: center;
        }

        .td-l {
            text-align: left;
        }

        .td-l a {
            color: orange;
        }

        .view-box {
            width: 500px;
            margin: 30px auto;
            border: 3px solid skyblue;
            padding: 30px;
        }

        .view-box h1 {
            text-align: center;
            font-size: 24px;
        }

        .view-box ul {
            padding: 30px;
        }

        .view-box ul li {
            margin-bottom: 10px;
            list-style: none;
            overflow: hidden;
        }

        .view-box ul li label {
            display: inline-block;
            width: 80px;
            margin-right: 5px;
        }

        .view-box ul li textarea {
            display: block;
            width: 98%;
            margin: 10px auto;
        }

        .btn-box {
            text-align: center;
        }

        .btn-box .btn {
            margin: 0px auto 20px;
        }
    </style>
</head>

<body>

    <div class="view-box">
        <h1>${article.title}</h1>

        <ul>
            <li>글번호: ${article.boardNo}</li>
            <li>작성자: ${article.writer}</li>
            <li>글내용: <br>
                <textarea name="content" cols="30" rows="20">${article.content}</textarea>
            </li>
        </ul>

        <div class="btn-box">
            <a class="btn" href="/board/list">목록보기</a>
            <a class="btn" href="/board/modify?boardNo=${article.boardNo}&vf=false">수정하기</a>
        </div>
    </div>

</body>

</html>