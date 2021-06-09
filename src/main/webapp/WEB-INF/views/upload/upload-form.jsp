<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>upload-form.jsp</title>

    <!-- static-head 조각 파일 인클루드 -->
    <%@ include file="../include/static-head.jsp" %>
</head>

<body>

    <!-- header 조각 파일 인클루드 -->
    <%@ include file="../include/header.jsp" %>


    <section id="upload-box">
        <!-- 파일 업로드를 위한 form -->
        <form action="/upload" method="POST" enctype="multipart/form-data">
            <input type="file" name="file" multiple>
            <button type="submit">업로드</button>
        </form>


        <!-- 비동기 통신을 통한 실시간 파일 업로드 -->
        <div class="fileDrop">
            <span>Drop Here!!</span>
        </div>

        <!-- 
        - 파일정보를 서버로 보내기 위해서는 <input type="file"> 이 필요함
        - 해당 태그는 사용자에게 나타내서 파일을 직접 탐색기를 통해 선택하게 할 것인지
          혹은 드래그 앤 드롭으로만 처리할 것이냐에 따라 display 상태를 결정
     -->

        <div class="uploadDiv">
            <input type="file" name="files" id="ajax-file" style="display: none;">
        </div>

        <!-- 업로드된 파일의 썸네일을 보여줄 영역 -->
        <div class="uploaded-list"></div>
    </section>


    <!-- footer 조각 파일 인클루드 -->
    <%@ include file="../include/footer.jsp" %>


    <!-- file-upload script 조각 파일 인클루드 -->
    <%@ include file="../include/file-upload.jsp" %>
</body>

</html>