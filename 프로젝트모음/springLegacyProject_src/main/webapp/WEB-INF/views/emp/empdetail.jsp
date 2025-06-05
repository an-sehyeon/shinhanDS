<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<%@ include file="../common/header.jsp" %>
	
	<h2>JSON이용 상세보기</h2>
	<input type="number" id="empid" value="100">
	<button id="btnDetail">상세보기(JSON)</button>
	<button id="btnUpdate">수정하기(JSON)</button>
	<button id="btnDelete">삭제하기(JSON)</button>
	<script src="${cpath}/resources/js/empDetail_json.js"></script>
	<script>
		$(function(){
			$("#btnDetail").on("click",f_selectById);
			$("#btnUpdate").on("click",f_update);
			$("#btnDelete").on("click",f_delete);
		});
	</script>

	<div id="container">
		<h1>${emp.employee_id}번직원 상세보기</h1>
		<hr>
		<form id="myfrm" action="${cpath}/emp/empdetail.do" method="post">
			<input type="hidden" name="job" value="update">
			<fieldset>
				<label>직원번호: </label><input id="emp_id_input" readonly="readonly"
					type="number" name="employee_id" value="${emp.employee_id}"><br>
				<label>성: </label><input type="text" name="first_name"
					value="${emp.first_name}"><br> <label>이름: </label><input
					type="text" name="last_name" value="${emp.last_name}"><br>
				<label>이메일: </label><input name="email" value="${emp.email}"><br>
				<label>급여: </label><input type="number" name="salary"
					value="${emp.salary}"><br> <label>커미션: </label><input
					type="number" name="commission_pct" value="${emp.commission_pct}"><br>
				<label>매니저: </label><input type="number" name="manager_id"
					value="${emp.manager_id}"><br> <label>전화번호: </label><input
					name="phone_number" value="${emp.phone_number}"><br> <label>부서:
				</label> <select name="department_id">
					<c:forEach items="${deptlist}" var="dept">
						<option value="${dept.department_id}"
							${dept.department_id == emp.department_id?"selected":""}>
							${dept.department_name}</option>
					</c:forEach>
				</select><br> <label>직책: </label> <select name="job_id">
					<c:forEach items="${joblist}" var="job">
						<option ${job.jobId == emp.job_id?"selected":""}>${job.jobId}</option>
					</c:forEach>
				</select><br> <label>입사일: </label><input type="date" name="hire_date"
					value="${emp.hire_date}"><br>
			</fieldset>
			<fieldset>
				<input type="button"
					onclick="location.href='${cpath}/emp/emplist.do'" value="확인">
				<input type="submit" value="수정">
			</fieldset>
		</form>
	</div>
</body>
</html>