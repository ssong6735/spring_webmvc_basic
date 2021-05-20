<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정 페이지</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>

    <div class="wrap">
        <h1>게시글 수정</h1>

        <div class="table-box">
            <form action="/board/modify" method="POST">
                <input type="hidden" name="boardNo" value="${article.boardNo}">
                <input type="hidden" name="vf" value="false">

                <table class="table write-table">
                    <tbody>
                        <tr>
                            <th width="10%"><label for="writer"># 작성자:</label></th>
                            <td width="15%"><input type="text" name="writer" value="${article.writer}"></td>
                            <th width="10%"><label for="title"># 글제목:</label></th>
                            <td><input type="text" name="title" value="${article.title}"></td>
                        </tr>

                        <tr>
                            <th colspan="4"><label for="content"># 내용</label></th>
                        </tr>
                        <tr>
                            <td colspan="4"><textarea name="content" cols="30" rows="15">${article.content}</textarea>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div class="list-btn">
                    <button type="submit" class="btn btn-basic">수정 완료</button>
                    <a class="btn btn-basic" href="/board/list">목록 보기</a>
                </div>
            </form>
        </div>

    </div>

</body>

</html>