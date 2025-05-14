<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서입력</h1>
	<hr>
	<form action="deptupdate.jsp">
		<input type="hidden" name="job" value="insert">
		<fieldset>
			<label>부서코드: </label><input type="number" name="department_id" autofocus="autofocus"> <br>
			<label>부서이름: </label><input name="department_name"> <br>
			<label>매니저번호: </label><input name="manager_id" placeholder="존재하는 직원번호"> <br>
			<label>지역코드: </label><input name="location_id" placeholder="존재하는 지역코드"> <br>
			<label>부서소개: </label><br> <textarea rows="5" cols="80"></textarea>
		</fieldset>
		<fieldset>
			<input type="submit" value="입력">
			<input type="reset" value="초기화">
			<input type="button" onclick="location.href='/webshop/day2/dept.html'" value="취소">
		</fieldset>
	</form>
</body>
</html>