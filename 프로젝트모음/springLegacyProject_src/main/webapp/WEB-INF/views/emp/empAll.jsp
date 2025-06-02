<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원조회</title>
<%@ include file="../common/header.jsp"%>


<link rel="stylesheet" href="${cpath}/resources/css/empAll.css">
<script src="${cpath}/resources/js/empAll.js"></script>
<script>
	var message = "${resultMessage}";
	if(message!=""){
		alert(message);
	}
	// load된 후 조회버튼 누르기
	$("#dept_job").trigger("click");
	
</script>
<script>
$(()=>{
	// ()=> {} 화살표함수에서 this는 window, bind()함수로 object를 bind()하여 this설정가능
	$("#search").on("keyup",function(){
		var inputData = $(this).val();
		console.log(inputData);
		$("tbody tr").hide();
		$(`td:contains(\${inputData})`).parent().show();		// <tr><td>aa</td></tr>
	});
	
	
});
</script>
<script>
$(function(){
	
	$("#dept_job").on("click",function(){
		const select = document.getElementById("deptid");
		const selectedValues = Array.from(select.selectedOptions)
								.map(option => option.value);
		
		var jobid =$("#jobid").val();
		var salary = $("#salary").val();
		var hire_date = $("#hire_date").val();
		var jsonData = {"deptid":$(select).val(),
				  "jobid":jobid,
				  "salary":salary,
				  "hire_date":hire_date
				  };
		console.log(jsonData);
		$.ajax({
			url:"/spring/emp/selectByCondition.do",
			contentType: "application/json",
			type:"post",
			data: JSON.stringify(jsonData),
			success:function(response){
				$("#here").html(response);
			}
		}); 
	});
	
	/*$("#deptid").on("change", function(){
		var deptid = $(this).val();
		$.ajax({
			url:"selectByDept.do",
			data:{"deptid":deptid},
			success:function(response){
				$("#here").html(response);
			}
		});
	});
});


$(function(){
	$("#jobid").on("change", function(){
		var jobid = $(this).val();
		$.ajax({
			url:"selectByJob.do",
			data:{"jobid":jobid},
			success:function(response){
				$("#here").html(response);
			}
		});
	});*/
});
</script>
<style>
h1 {
	text-align: center;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

h2 {
	text-align: center;
}

th, td {
	padding: 3px;
}

thead tr {
	background: #EADCF8;
	border-bottom: 2px solid black;
}

tbody tr:nth-child(2n) {
	background-color: #DFF5E1;
}

tbody tr:nth-child(2n+1) {
	background-color: #FFE5EC;
}

/* td[first_name *= 'e'] { background-color: #FFE65A; }
	
	td[email ^= 'S'] { background-color: #BEF5BE; }
	
	td[dept_id *= '60'] { background-color: skyblue; }
	
	td[salary_over_8000 = 'true'] { background-color: pink; }  */
#container {
	width: 1000px;
	margin: 0 auto;
}

.login {
	color: blue;
}

.logout {
	color: black;
}
</style>
</head>
<body>

	<div id="container">
		<h1 class="title">직원목록</h1>
		<a class="btn btn-success" href="${cpath}/emp/empinsert.do">신규직원등록</a>
		<hr>
		부서로조회: <select id="deptid" multiple="multiple">
			<c:forEach items="${deptlist}" var="dept">
				<option value="${dept.department_id}"
					${dept.department_id==50?"selected":""}>
					${dept.department_id}-${dept.department_name}</option>
			</c:forEach>
		</select> 직책으로조회: <select id="jobid">
			<c:forEach items="${joblist}" var="job">
				<option ${job.jobId=="ST_CLERK"?"selected":""}>${job.jobId}</option>
			</c:forEach>
		</select> 급여조회(이상):<input type="number" id="salary" value="1000">
		입사일(이상) :<input type="date" id="hire_date" value="2000-01-01">
		<button id="dept_job">조건조회</button>




		<hr>
		급여:<input type="number" id="sal" value="5000">이상
		<button id="search1">직원찾기(스타일변경)</button>
		찾을문자:<input type="text" id="search2">

		<hr>
		<table class="table table-striped">
			<caption>모든직원List</caption>
			<thead>
				<tr>
					<th>순서</th>
					<th>로그인여부</th>
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
							<td>${status.index}<span>👍👍</span>${status.count}
							<span>${status.first?"처음":"" }</span>
							<span>${status.last?"마지막":"" }</span>
						</td>
						<td>
						<c:if test="${loginEmp.employee_id==emp.employee_id}">
							<span class="login">로그인중</span>
						</c:if>
						<c:if test="${loginEmp.employee_id!=emp.employee_id}">
							<span class="logout">직원</span>
						</c:if>
						</td>
						<td>
						<a href="${cpath}/emp/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
						<td>${emp.first_name}</td>
						<td>${emp.last_name}</td>
						<td>${emp.email}</td>
						<td>${emp.phone_number}</td>
						<td><fmt:formatDate pattern="yyyy-mm-dd hh:mm:ss"
								value="${emp.hire_date}" /></td>
						<td>${emp.job_id}</td>
						<td><fmt:formatNumber type="currency" currencySymbol="$"
								groupingUsed="true" value="${emp.salary}"></fmt:formatNumber></td>
						<td>${emp.commission_pct}</td>
						<td>${emp.manager_id}</td>
						<td>${emp.department_id}</td>
						<td><a
							href="${cpath}/emp/empdelete.do?empid=${emp.employee_id}"> <c:if
									test="${status.index%2==0}">
							🗑					
						</c:if> <c:if test="${status.index%2==1}">
							❤️					
						</c:if>
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>







