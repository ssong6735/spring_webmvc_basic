<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 등록 페이지</title>

    <!-- static-head 조각 파일 인클루드 -->
    <%@ include file="../include/static-head.jsp" %>
</head>

<body>

    <div class="wrap">
        <h1>게시글 등록</h1>

        <div class="table-box">
            <form action="/board/write" method="POST">
                <table class="table write-table">
                    <tbody>
                        <tr>
                            <th width="10%"><label for="writer"># 작성자:</label></th>
                            <td width="15%"><input type="text" name="writer"></td>
                            <th width="10%"><label for="title"># 글제목:</label></th>
                            <td><input type="text" name="title"></td>
                        </tr>

                        <tr>
                            <th colspan="4"><label for="content"># 내용</label></th>
                        </tr>
                        <tr>
                            <td colspan="4"><textarea name="content" cols="30" rows="15"></textarea></td>
                        </tr>
                    </tbody>
                </table>

                <div class="list-btn">
                    <button type="submit" class="btn btn-basic">새글 등록</button>
                    <a class="btn btn-basic" href="/board/list">목록 보기</a>
                </div>

                <!-- Button trigger modal 모달기능 가려놓음. 사용하려면 fade 지우기 -->
                <button type="button" class="btn btn-primary fade" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    모달 테스트
                </button>
            </form>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- footer 조각 파일 인클루드 -->
    <%@ include file="../include/footer.jsp" %>

</body>

</html>