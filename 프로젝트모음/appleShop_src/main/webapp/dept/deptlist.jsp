<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<h1>부서목록조회</h1>
	<hr>
	<form action="${cpath}/dept/deptdelete" method="post">
	<input type="submit" value="선택삭제">
	<table border="1">
		<thead>
			<tr>
				<th>부서코드</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역코드</th>
				<th>삭제</th>
				<th>선택</th>
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
					<td>
						<input type="checkbox" name="del" value="${dept.department_id}">삭제
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</body>
	</html>
					