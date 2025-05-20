<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서목록조회</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>부서코드</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역코드</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ deptListData }" var="dept">
				<tr>
					<td><a href="deptdetail?deptid=${dept.department_id }">${dept.department_id }</a></td>
					<td>${dept.department_name }</td>
					<td>${dept.manager_id }</td>
					<td>${dept.location_id }</td>
					<td><a href="deptdelete?deptid=${dept.department_id }">🗑️</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>