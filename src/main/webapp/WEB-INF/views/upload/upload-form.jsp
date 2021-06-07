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


    <!-- 파일 업로드를 위한 form -->
    <form action="/upload" method="POST" enctype="multipart/form-data">
        <input type="file" name="file" multiple>
        <button type="submit">업로드</button>    
    </form>


    <!-- footer 조각 파일 인클루드 -->
    <%@ include file="../include/footer.jsp" %>
</body>
</html>