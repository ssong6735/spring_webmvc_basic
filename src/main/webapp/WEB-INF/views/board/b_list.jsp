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

    <!-- header 조각 파일 인클루드 -->
    <%@ include file="../include/header.jsp" %>


    <div class="wrap">
        <h1>게시글 목록</h1>

        <div class="table-box">

            <!-- 게시글 보기 수량 선택 -->
            <div class="amount">
                <a href="/board/list${pageMaker.makeParam(pageMaker.criteria.page, 10)}">10</a>
                <a href="/board/list${pageMaker.makeParam(pageMaker.criteria.page, 20)}">20</a>
                <a href="/board/list${pageMaker.makeParam(pageMaker.criteria.page, 30)}">30</a>
            </div>

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
                                <td>
                                    <a
                                        href="/board/content${pageMaker.makeParam(pageMaker.criteria.page)}&boardNo=${article.boardNo}&vf=true">
                                        ${article.title}
                                        <!-- 댓글이 있을때만 댓글 카운트 보여지게 하기 -->
                                        <c:if test="${replyList.size() > 0}">
                                            <span id="replyCnt">0</span>
                                        </c:if>
                                    </a>
                                    
                                </td>
                                <td>${article.writer}</td>
                                <td>${article.viewCnt}</td>
                                <td>
                                    <c:if test="${article.writer == loginUser.account || loginUser.auth == 'ADMIN'}">
                                        <a class="del-btn" href="/board/delete?boardNo=${article.boardNo}">삭제</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>

                    </c:if>

                </tbody>
            </table>

            <!-- 검색창 영역 -->
            <div class="search">
                <form class="search-box" action="/board/list" id="search-form">
                    <input type="hidden" name="amount" value="${pageMaker.criteria.amount}">
                    <div class="search-line">
                        <select name="type">
                            <option value="title" ${pageMaker.criteria.type=='title' ? 'selected' : '' }>제목</option>
                            <option value="content" ${pageMaker.criteria.type=='content' ? 'selected' : '' }>내용</option>
                            <option value="writer" ${pageMaker.criteria.type=='writer' ? 'selected' : '' }>작성자</option>
                            <option value="titleContent" ${pageMaker.criteria.type=='titleContent' ? 'selected' : '' }>
                                제목+내용</option>
                        </select>
                        <input type="text" name="keyword" placeholder="검색어를 입력하세요!"
                            value="${pageMaker.criteria.keyword}">
                        <button type="submit">검색</button>
                    </div>
                </form>
            </div>

            <div class="list-btn align-r">
                <a class="btn btn-basic" href="/board/write">글쓰기</a>
            </div>

            <!-- 페이지 영역 -->
            <ul class="pagination">

                <c:if test="${pageMaker.prev}">
                    <li>
                        <a href="/board/list${pageMaker.makeParam(pageMaker.beginPage-1)}">[prev]</a>
                    </li>
                </c:if>
                <!-- li*5>a{[$]} -->
                <c:forEach var="i" begin="${pageMaker.beginPage}" end="${pageMaker.endPage}" step="1">
                    <li data-page="${i}"><a href="/board/list${pageMaker.makeParam(i)}">[${i}]</a></li>
                </c:forEach>

                <c:if test="${pageMaker.next}">
                    <li>
                        <a href="/board/list${pageMaker.makeParam(pageMaker.endPage+1)}">[next]</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>


    <!-- footer 조각 파일 인클루드 -->
    <%@ include file="../include/footer.jsp" %>


    <script>
        //현재 위치한 페이지넘버에 클래스 active를 부여하는 함수 정의
        function appendPageActive(curPageNum) {
            const $ul = document.querySelector('.pagination');
            for (let $li of [...$ul.children]) {
                if ($li.dataset.page === curPageNum) {
                    $li.classList.add('active');
                }
            }
        }
        (function () {
            appendPageActive('${pageMaker.criteria.page}');
        }());
    </script>

</body>

</html>