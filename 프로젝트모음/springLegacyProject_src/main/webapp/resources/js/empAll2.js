$(()=>{
	// ()=> {} 화살표함수에서 this는 window, bind()함수로 object를 bind()하여 this설정가능
	$("#search").on("keyup",function(){
		var inputData = $(this).val();
		console.log(inputData);
		$("tbody tr").hide();
		$(`td:contains(\${inputData})`).parent().show();		// <tr><td>aa</td></tr>
	});
});

$(function(){
	
	$("#dept_job").on("click",function(){
		const select = document.getElementById("deptid");
		const selectedValues = Array.from(select.selectedOptions)
								.map(option => option.value);
		
		var jobid =$("#jobid").val();
		var salary = $("#salary").val();
		var hire_date = $("#hire_date").val();
		var date_check = $("#date_check").prop("checked");
		var jsonData = {"deptid":$(select).val(),
				  "jobid":jobid,
				  "salary":salary,
				  "hire_date":hire_date,
				  "date_check":date_check
				  };
		console.log(jsonData);
		console.log(date_check);
		
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