<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록 페이지</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>





    <div class="wrap">
        <h1>게시글 목록</h1>

        <div class="table-box">
            <table class="table list-table">
                <tbody>
                    <tr>
                        <th width="7%">No</th>
                        <th>글제목</th>
                        <th width="10%">작성자</th>
                        <th width="10%">조회수</th>
                        <th width="10%">비고</th>
                    </tr>

                    <%-- 게시물 개수가 0개일 경우 목록대신 "게시물이 존재하지 않습니다." 출력 --%>
                    <c:if test="${articles.size() <= 0}">
                        <tr>
                            <td class="no-article" colspan="5">게시물이 존재하지 않습니다.</td>
                        </tr>
                    </c:if>

                    <c:if test="${articles.size() > 0}">

                        <%-- 컨트롤러가 가져온 게시글 데이터를 반복하여 출력. --%>
                        <c:forEach var="article" items="${articles}">
                            <tr>
                                <td>${article.boardNo}</td>
                                <td><a href="/board/content?boardNo=${article.boardNo}&vf=true">${article.title}</a>
                                </td>
                                <td>${article.writer}</td>
                                <td>${article.viewCnt}</td>
                                <td><a class="del-btn" href="/board/delete?boardNo=${article.boardNo}">삭제</a></td>
                            </tr>
                        </c:forEach>

                    </c:if>

                </tbody>
            </table>
        </div>

        <div class="list-btn">
            <a class="btn btn-basic" href="/board/write">글쓰기</a>
        </div>
    </div>



</body>

</html>