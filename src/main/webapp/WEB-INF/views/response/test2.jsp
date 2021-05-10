<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>test2.jsp</title>

    <style>
        label {
            display: block;
        }
    </style>
</head>

<body>

    <p>${user}</p>

    <!-- getter가 있는경우 필드명을 바로 쓸수 있다. -->
    <h1>${user.userName}님 가입정보</h1>
    <div># 아이디: ${user.userId}</div>
    <div># 패스워드: ${user.userPw}</div>
    <div># 취미: ${user.hobby}</div>

</body>

</html>