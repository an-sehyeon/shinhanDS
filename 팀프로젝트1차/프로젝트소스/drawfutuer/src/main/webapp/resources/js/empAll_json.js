var obj = {
			"employee_id": 2,
	        "first_name": "테스트",
	        "last_name": "TT",
	        "email": "SKING3",
	        "phone_number": "515.123.4567",
	        "hire_date": 1055775600000,
	        "job_id": "AD_PRES",
	        "salary": 24000.0,
	        "commission_pct": null,
	        "manager_id": null,
	        "department_id": 60
	};
	
	function f_delete(){
		console.log("f_delete--구현");
		var empid = $("#empid").val();
		$.ajax({
			url:`${cpath}/emp/api/empdelete.do/${empid}`,
			type:"delete",
			contentType:"application/json;charset=utf-8",
			success: function(response){
				console.log(response);
			}
		});
	}
	
	function f_update(){
		console.log("f_update--구현");
		
		$.ajax({
			url:`${cpath}/emp/api/empupdate.do`,
			type:"put",
			data: JSON.stringify(obj),
			contentType:"application/json;charset=utf-8",
			success: function(response){
				console.log(response);
			}
		});
	}
	
	function f_insert(){
		console.log("f_insert--구현");

		$.ajax({
			url:`${cpath}/emp/api/empinsert.do`,
			type:"post",
			data: JSON.stringify(obj),
			contentType:"application/json;charset=utf-8",
			success: function(response){
				console.log(response);
			}
		});
	}
	
	function f_selectById(){
		console.log("f_selectById--구현");
		var empid = $("#empid").val();
		$.ajax({
			url:`${cpath}/emp/api/empdetail.do/${empid}`,
			success: function(response){
				console.log(response);
			}
		});
	}
	
	
	function f_selectAll(){
		console.log("f_selectAll--구현");
		$.ajax({
			url:`${cpath}/emp/api/emplist.do`,
			success: f_selectAll_print
		});
	}
	
	
function f_convertDate(date) {
  let [y, m, d] = date.toLocaleDateString("ko-KR")
    .replace(/\.$/, '')
    .split('. ')
    .map(s => s.padStart(2, '0'));
  return `${y}-${m}-${d}`;
}
	
	
	function f_selectAll_print(responseArr){
	
		var output = "";
		var cpath = "/spring";
		var v_last = responseArr.length -1;
		
		
		$.each(responseArr, function(index, emp){
			var message1 = (index ==0)?"처음":"";
			var message2 = (index==v_last)?"끝":"";
			
			var hdate = new Date(Number(emp.hire_date));
			hdate = f_convertDate(hdate);
			
			var odd_img =`<img src="${cpath}/resources/images/healing.jpg" width="30" height="30">`;
			var even_img =`<img src="${cpath}/resources/images/delete3.png" width="30" height="30">`;
			var img_output = odd_img;
			if(index%2==0)img_output = even_img;
			
			output += `
		<tr>
					<td>${index}
						<span>👍👍</span>
						<span>${message1}</span>
						<span>${message2}</span>
					</td>
					<td>직원</td>
					<td><a href="${cpath}/emp/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td>${emp.first_name}</td>
					<td>${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>${hdate}</td>
					<td>${emp.job_id}</td>
					<td>${emp.salary}</td>
					<td>${emp.commission_pct}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.department_id}</td>
					<td><a href="${cpath}/emp/empdelete.do?empid=${emp.employee_id}">
						${img_output}
					</a>
					</td>
					
			</tr>
		
		`;
		});
		console.log(output);
		$("#here").html(output);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	