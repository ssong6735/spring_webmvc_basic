<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>test.jsp</title>
</head>

<body>

    <h1>test.jsp 파일 입니다.</h1>
    <p>
        <%@ EL: expression language (서버가 모델에 담아둔 내용을 활용할때 사용하는 문법 ${}) %>
        제 나이는 ${userAge}세 입니다. <br>
        나는 ${nickName}이다.
    </p>

</body>

</html>