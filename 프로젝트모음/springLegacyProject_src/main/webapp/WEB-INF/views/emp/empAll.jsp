<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원조회</title>
<%@ include file="../common/header.jsp" %>
 

<link rel="stylesheet" href="${cpath}/resources/css/empAll.css"> 
<script src="${cpath}/resources/js/empAll.js"></script>

</head>
<body>

<div id="container">
<h1 class="title">직원목록</h1>
<a class="btn btn-success" href="${cpath}/emp/empinsert.do">신규직원등록</a>
<hr>
부서로조회:
<select id="deptid" multiple="multiple" >
  <c:forEach items="${deptlist}" var="dept">
    <option value="${dept.department_id}" ${dept.department_id==50?"selected":""}>
         ${dept.department_id}-${dept.department_name}
    </option>
  </c:forEach>
</select>

직책으로조회:
<select id="jobid">
  <c:forEach items="${joblist}" var="job">
    <option ${job.jobId=="ST_CLERK"?"selected":""}  >${job.jobId}</option>
  </c:forEach>
</select>
급여조회(이상):<input type="number" id="salary" value="1000">
입사일(이상) :<input type="date" id="hire_date" value="2000-01-01">
<button id="dept_job">조건조회</button>




<hr>
급여:<input type="number" id="sal" value="5000">이상
 <button id="search1">직원찾기(스타일변경)</button>
 찾을문자:<input type="text" id="search2"  >

<hr>
<table class="table table-striped">
 <caption>모든직원List</caption>
 <thead>
   <tr>
     <th>직원번호</th>
     <th>이름</th>
     <th>성</th>
     <th>이메일</th>  
     <th>전화번호</th>
     <th>입사일</th>
     <th>직책</th>
     <th>급여</th>
     <th>커미션</th>
     <th>메니저</th>
     <th>부서</th>
     <th>삭제</th>
   </tr>
 </thead>
 <tbody id="here">
 	<c:forEach items="${ emplist }" var="emp" varStatus="status">
				<tr>
					<td><a href="${cpath}/emp/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td>${emp.first_name}</td>
					<td>${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>
						<fmt:formatDate pattern="yyyy-mm-dd hh:mm:ss" value="${emp.hire_date}"/>
					</td>
					<td>${emp.job_id}</td>
					<td>
						<fmt:formatNumber type="currency" currencySymbol="$" groupingUsed="true" value="${emp.salary}"></fmt:formatNumber>
					</td>
					<td>${emp.commission_pct}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.department_id}</td>
					<td><a href="${cpath}/emp/empdelete.do?empid=${emp.employee_id}">
						<c:if test="${status.index%2==0}">
							🗑					
						</c:if>
						<c:if test="${status.index%2==1}">
							❤️					
						</c:if>
					</a>
					</td>
					
				</tr>
			</c:forEach>
 </tbody>
</table>
</div>
</body>
</html>







