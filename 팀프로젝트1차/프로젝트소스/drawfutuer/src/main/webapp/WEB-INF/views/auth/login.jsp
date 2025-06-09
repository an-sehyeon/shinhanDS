<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<script src="${cpath}/resources/js/loginExternal.js">

</script>
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<div class="container mt-3">
		<form action="${cpath}/auth/login.do" method="post"  id="myfrm">
			<div class="mb-3 mt-3">
				<label for="email">사용자아이디(직원번호):</label> 
				<input type="number" class="form-control" id="email" placeholder="id 입력" name="userid" value="100">
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" value="SKING">
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" value="ok" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
			
		</form>
	</div>
</body>
</html>