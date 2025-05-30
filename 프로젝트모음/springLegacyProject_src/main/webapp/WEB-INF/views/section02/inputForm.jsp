<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/header.jsp" %>
</head>
<body>
	<h1>입력받기</h1>
	<form action="${cpath}/section02/friday.do">
		사용자번호 : <input name="userid"><br>
		비밀번호 : <input name="pwd"><br>
		이메일 : <input name="email"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>