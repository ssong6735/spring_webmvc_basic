<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록 페이지</title>
    <link rel="stylesheet" href="/css/main.css">

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

        tr:hover {
            background: #eee;
        }

        th {
            padding: 5px;
            text-align: center;
            background: #333;
            color: #fff;
        }

        td {
            text-align: center;
            width: 10%;
        }

        .td-l {
            text-align: left;
            width: 40%;
        }

        .td-l a {
            color: orange;
            display: block;
            padding: 5px;
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

    <%-- 게시물 개수가 0개일 경우 목록대신 "게시물이 존재하지 않습니다." 출력 --%>
    <c:if test="${articles.size() <= 0}">
        <p>게시물이 존재하지 않습니다.</p>
    </c:if>

    <c:if test="${articles.size() > 0}">

        <h1>게시글 목록</h1>

        <table class="board-list">
            <tbody>
                <tr>
                    <th>글번호</th>
                    <th>작성자</th>
                    <th>글제목</th>
                    <th>조회수</th>
                    <th>비고</th>
                </tr>

                <%-- 컨트롤러가 가져온 게시글 데이터를 반복하여 출력. --%>
                <c:forEach var="article" items="${articles}">
                    <tr>
                        <td>${article.boardNo}</td>
                        <td>${article.writer}</td>
                        <td class="td-l"><a
                                href="/board/content?boardNo=${article.boardNo}&vf=true">${article.title}</a></td>
                        <td>${article.viewCnt}</td>
                        <td><a class="del-btn" href="/board/delete?boardNo=${article.boardNo}">삭제</a></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </c:if>
    <div>
        <a class="btn" href="/board/write">글쓰기</a>
    </div>

</body>

</html>