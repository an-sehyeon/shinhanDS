<%@page import="com.shinhan.job.JobDAO"%>
<%@page import="com.shinhan.job.JobDTO"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DeptService dService = new DeptService();
List<DeptDTO> deptlist = dService.selectAll();
List<JobDTO> joblist = new JobDAO().getAllJobs();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 75px;
		text-align: center;
		padding: 1px;
	}
	select, input#calender {
		text-align: center;
		width: 170px;
	}
</style>
</head>
<body>
	<h1>직원 입력</h1>
	<hr>
	<form action="empupdate.jsp">
		<input type="hidden" name="job" value="insert">
		<fieldset>
			<label>직원번호: </label><input type="number" name="employee_id" autofocus="autofocus"><br>
			<label>성: </label><input type="text" name="first_name""><br>
			<label>이름: </label><input type="text" name="last_name""><br>
			<label>이메일: </label><input name="email""><br>
			<label>급여: </label><input type="number" name="salary""><br>
			<label>부서: </label>
			<select name="department_id">
				<%
					for(DeptDTO dept : deptlist) {
						out.print("<option value='" + dept.getDepartment_id() + "'>");
						out.print(dept.getDepartment_name());
						out.print("</option>");
					}
				%>
			</select><br>
			<label>커미션: </label><input type="number" name="commission_pct"><br>
			<label>매니저: </label><input type="number" name="manager_id"><br>
			<label>전화번호: </label><input name="phone_number"><br>
			<label>직책: </label>
			<select name="job_id">
				<%
					for(JobDTO job : joblist) {
						out.print("<option value='" + job.getJobId() + "'>");
						out.print(job.getJobId());
						out.print("</option>");
					}
				%>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date" id="calender"><br>
		</fieldset>
		<fieldset>
			<input type="submit" value="입력">
			<input type="reset" value="초기화">
			<input type="button" onclick="location.href='/webshop/day1/emp.html'" value="취소">
		</fieldset>
	</form>
</body>
</html>