<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- request.setAttribute("cpath","/appleShop") -->
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#emp_id_input { background-color: #E1F6FA }
</style>
</head>
<body>
	<!-- request > session > application -->
	<p>현재로그인한 직원: ${loginEmp.first_name}</p>

	<h1>신규 직원 등록</h1>
	<input type="button" onclick="location.href='${cpath}/emp/emplist.do'" value="돌아가기">
	<br>
	<hr>
	<form action="${cpath}/emp/empinsert.do" method="post">
		<input type="hidden" name="job" value="update">
		<fieldset>
			<label>직원번호: </label><input id="emp_id_input" type="number" name="employee_id"><br>
			<label>성: </label><input type="text" name="first_name"><br>
			<label>이름: </label><input type="text" name="last_name"><br>
			<label>이메일: </label><input name="email"><br>
			<label>급여: </label><input type="number" name="salary"><br>
			<label>커미션: </label><input type="number" name="commission_pct"><br>
			<label>매니저:</label>
			<select name="manager_id">
				<c:forEach items="${managerId}" var="mid">
					<option value="${mid}">
						${mid}
					</option>
				</c:forEach>
			</select><br>
			<label>전화번호: </label><input name="phone_number"><br>
			<label>부서: </label>
			<select name="department_id">
				<c:forEach items="${deptlist}" var="dept">
					<option value = "${dept.department_id}" ${dept.department_id == emp.department_id?"selected":""}>
						${dept.department_name}
					</option>
				</c:forEach>
			</select><br>
			<label>직책: </label>
			<select name="job_id">
				<c:forEach items="${joblist}" var="job">
					<option ${job.jobId == emp.job_id?"selected":""}>${job.jobId}</option>
				</c:forEach>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date"><br>
		</fieldset>
		<fieldset>
			<input type="submit" value="등록">
		</fieldset>
	</form>
</body>
</html>