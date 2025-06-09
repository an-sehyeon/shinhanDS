function f_update(){
	console.log("f_update--구현");
	var obj = { };
	var arr = $("#myfrm").serializeArray();
	console.log(arr);
	$.each(arr,function(index,item){
		obj[item.name] = item.value;
	});
	$.ajax({
				url : `api/empupdate.do`,
				type : "put",
				data : JSON.stringify(obj),
				contentType : "application/json;charset=utf-8",
				success : function(response) {
					console.log(response);
				}
			}); 
}



function f_delete(){
		console.log("f_delete--구현");
		var empid = $("#empid").val();
		$.ajax({
			url:`api/empdelete.do/${empid}`,
			type:"delete",
			success: function(response){
				console.log(response);
			}
		});
	}





function f_make_jobSelect(joblist, emp_job){
	var output = "<select name='job_id'>";
	$.each(joblist,function(index, job){
		var select_job = emp_job == job.jobId?"selected":"";
		output+= `<option ${select_job}>${job.jobId}</option>`;
	});
	
	return output + "</select>";
}

function f_make_deptSelect(deptlist, emp_deptid){
	var output = "<select name='department_id'>";
	$.each(deptlist,function(index, dept){
	var select_dept = emp_deptid == dept.department_id?"selected":"";
		output+= `<option ${select_dept} value="${dept.department_id}>${dept.department_name}</option>`;
	});
	
	return output + "</select>";
}


function f_convertDate(date) {
  let [y, m, d] = date.toLocaleDateString("ko-KR")
    .replace(/\.$/, '')
    .split('. ')
    .map(s => s.padStart(2, '0'));
  return `${y}-${m}-${d}`;
}


function f_selectById(){
			console.log("f_selectById--구현");
			var empid = $("#empid").val();
			var cpath = "/spring";
			
			$.ajax({
				url:`${cpath}/emp/api/empdetail.do/${empid}`,
				success: function(mapData){
					
					// JSON객체를 받아서 화면 display다시하기
					var emp = mapData.emp;
					var job_output = f_make_jobSelect(mapData.joblist, emp.job_id);
					var dept_output = f_make_deptSelect(mapData.deptlist, emp.job_id, emp.department_id);
					
					var hdate = new Date(Number(emp.hire_date));
					hdate = f_convertDate(hdate);

					var commission = `${emp.commission_pct}`;
					
					var output = `
						<h1>${emp.employee_id}번직원 상세보기</h1>
						<hr>
						<form id="myfrm" action="${cpath}/emp/empdetail.do" method="post">
						<input type="hidden" name="job" value="update">
						<fieldset>
							<label>직원번호: </label>
							<input id="emp_id_input" readonly="readonly" type="number" name="employee_id" value="${emp.employee_id}"><br>
							
							<label>성: </label>
							<input type="text" name="first_name" value="${emp.first_name}"><br>
							
							<label>이름: </label>
							<input type="text" name="last_name" value="${emp.last_name}"><br>
							
							<label>이메일: </label>
							<input name="email" value="${emp.email}"><br>
							
							<label>급여: </label>
							<input type="number" name="salary" value="${emp.salary}"><br>
							
							<label>커미션: </label>
							<input type="number" name="commission_pct" value="${commission}"><br>
							
							<label>매니저: </label>
							<input type="number" name="manager_id" value="${emp.manager_id}"><br>
							
							<label>전화번호: </label>
							<input name="phone_number" value="${emp.phone_number}"><br>
							
							<label>부서: </label>
							${dept_output}
							<br>
							
							<label>직책: </label>
							${job_output}
							<br>
							
							<label>입사일: </label>
							<input type="date" name="hire_date" value="${hdate}"><br>
						</fieldset>
						
						<fieldset>
							<input type="button" onclick="location.href='${cpath}/emp/empAll.do'" value="확인">
							<input type="submit" value="수정">
						</fieldset>
					</form>
					`;
					$("#container").html(output);
				}
			});
		}