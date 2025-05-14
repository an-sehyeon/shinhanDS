<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
EmpService eService = new EmpService();
List<EmpDTO> emplist = eService.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
	h1 { text-align: center; }
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	th, td { padding: 3px; }
	
	thead tr { background: #EADCF8; border-bottom: 2px solid black; }
	
	tbody tr:nth-child(2n){ background-color: #DFF5E1;}
	tbody tr:nth-child(2n+1) { background-color: #FFE5EC; }
	
	/* td[first_name *= 'e'] { background-color: #FFE65A; }
	
	td[email ^= 'S'] { background-color: #BEF5BE; }
	
	td[dept_id *= '60'] { background-color: skyblue; }
	
	td[salary_over_8000 = 'true'] { background-color: pink; }  */
	
	#container {
		width: 1000px;
		margin: 0 auto;
	}
	
</style>
<script>
window.onload=function(){
	
	// 초기화 버튼
	document.getElementById("resetbtn").addEventListener("click",function(){
		// 모든 테이블 행을 가져옴
	    var rows = document.querySelectorAll("tr");

	    // 각 행의 배경색을 초기화
	    rows.forEach((row) => {
	        row.style.backgroundColor = ""; // 원래 색으로 복원
	    });

	    // 입력창의 값을 초기화
	    document.getElementById("salaryInput").value = "";
	    
	    // div영역의 결과도 초기화
	    document.getElementById("s_list").innerHTML = "";
	});
	
	
	
	
	
	
	// 조회 버튼
	document.getElementById("selectbtn").addEventListener("click", function () {
	    // 사용자가 입력창에 입력한 급여 값을 가져옴 
	    var inputSalary = document.getElementById("salaryInput").value;
	    // 테이블의 모든 행을 가져옴
	    var rows = document.querySelectorAll("tr");
	    
	    // 기존의 결과를 비우고 새로운 테이블을 만들기 위해 초기화
	    var selectedListDiv = document.getElementById("s_list");
	    selectedListDiv.innerHTML = "";		// 이전 검색 결과 초기화
	    
	    // 조건에 맞는 행을 담을 새로운 테이블 요소 생성
	    var newTable = document.createElement("table");
	    newTable.border = "1";
	    newTable.style.width = "100%";

	    // 모든 행을 순회, 급여 확인
	    rows.forEach((row, index) => {
	        // 행에서 급여가 포함된 셀을 찾습니다.
	        var salaryCell = row.querySelector(".salary");

	        if (salaryCell) {
	            // 셀의 텍스트 내용을 숫자로 변환
	            var salary = parseFloat(salaryCell.textContent);

	            // 입력된 급여 이상인 경우 배경색을 변경
	            if (salary >= parseFloat(inputSalary)) {
	                row.style.backgroundColor = "#FFF3B0"; 
		           
	                // 조건을 만족하는 행만 복사해서 새로운 테이블에 추가
	                var cloneRow = row.cloneNode(true);	// true : 자식 노드까지 복제
	                newTable.appendChild(cloneRow);		// 새로운 테이블에 추가
	                
	            } else {
	                row.style.backgroundColor = "#B0E0FF";  
	            }
	        }
	    });
	    
	    // 조건을 만족하는 데이터가 있을때만 div에 삽입
	    if(newTable.rows.length > 0){
	    	selectedListDiv.innerHTML ="<p>조회 결과 직원 정보</p><br>";
	    	selectedListDiv.appendChild(newTable);
	    }else{
	    	selectedListDiv.innerHTML ="<p>해당 조건의 직원이 없습니다.</p>";
	    }
	});
}
</script>
</head>
<body>
  <div id="container">
	<h1 class="title">직원목록 조회</h1>
	<button type="button" onclick="location.href='/web/day01/jsp/empinsert.jsp'" class="btn btn-success">신규직원등록</button>
	<button type="button" onclick="location.href='/web/index.html'" class="btn btn-info">컴백홈</button>
	<hr>
	급여:<input type="number" id="salaryInput">이상
	<button id="selectbtn">직원찾기(스타일변경)</button>
	<button id="resetbtn">초기화</button>
	<br><br>
	<hr>
	<div id="s_list"></div>
	<br>
	<hr>
	<br>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>직원번호</th>
				<th>이름</th>
				<th>성</th>
				<th>이메일</th>
				<th>급여</th>
				<th>부서</th>
				<th>커미션</th>
				<th>매니저</th>
				<th>전화번호</th>
				<th>직책</th>
				<th>입사일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<%
			int cnt = 1;
			for(EmpDTO emp : emplist) {
				out.print("<tr>");
				out.print("<td>"+ cnt++ + "</td>");
				out.print("<td><a href='empdetail.jsp?emp_id=" + emp.getEmployee_id() + "'>" + emp.getEmployee_id() + "</a></td>");
				out.print("<td first_name='" + emp.getFirst_name() + "'>"+ emp.getFirst_name() + "</td>");
				out.print("<td>"+ emp.getLast_name() + "</td>");
				out.print("<td email='" + emp.getEmail() + "'>"+ emp.getEmail() + "</td>");
				out.print("<td class='salary' salary_over_8000='" + (emp.getSalary()>8000?"true":"false") + "'>"+ emp.getSalary() + "</td>");
				out.print("<td dept_id='" + emp.getDepartment_id() + "'>"+ emp.getDepartment_id() + "</td>");
				out.print("<td>"+ emp.getCommission_pct() + "</td>");
				out.print("<td>"+ emp.getManager_id() + "</td>");
				out.print("<td>"+ emp.getPhone_number() + "</td>");
				out.print("<td>"+ emp.getJob_id() + "</td>");
				out.print("<td>"+ emp.getHire_date() + "</td>");
				out.print("<td><button type='button' class='btn btn-danger' onclick=\"location.href='empdelete.jsp?emp_id="
					    + emp.getEmployee_id()
					    + "'\">🗑</button></td>");
				out.print("</tr>");
			}
		%>
	</tbody>	
	</table>
  </div>
</body>
</html>