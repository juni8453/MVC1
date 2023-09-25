<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 상대 경로로 사용
WEB-INF 밑에 있는 자원들은 외부에서 호출해도 그냥 호출되지 않는다.
Controller 에서 호출되야하는 자원들은 WEB-INF 밑에 만들면 됨.
-->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>