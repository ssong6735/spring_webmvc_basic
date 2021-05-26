<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록 페이지</title>
    
    <!-- static-head 조각 파일 인클루드 -->
    <%@ include file="../include/static-head.jsp" %>
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

    <!-- footer 조각 파일 인클루드 -->
    <%@ include file="../include/footer.jsp" %>

</body>

</html>