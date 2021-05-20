<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 상세보기 페이지</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>

    <div class="wrap">
        <h1>No.${article.boardNo} 글 상세보기</h1>

        <div class="table-box">


            <table class="table view-table">
                <tbody>
                    <tr>
                        <th width="10%"># 작성자:</th>
                        <td width="15%">${article.writer}</td>
                        <th width="10%"># 글제목:</th>
                        <td>${article.title}</td>
                    </tr>

                    <tr>
                        <th colspan="4"># 내용</th>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea class="content-box" name="content" cols="30" rows="15" disabled>${article.content}</textarea>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div class="list-btn">
                <a class="btn btn-basic" href="/board/modify?boardNo=${article.boardNo}&vf=false">글수정</a>
                <a class="btn btn-basic" href="/board/list">목록 보기</a>
            </div>
        </div>

    </div>

</body>

</html>