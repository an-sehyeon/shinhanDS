<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>주택청약접수 메인 페이지</title>
<link rel="stylesheet" type="text/css" href="${cpath}/auth/login.css">
<script src="${cpath}/auth/login.js"></script>
</head>
<body>
	<br><br>
	<h1>주택청약 접수처</h1>
	<br><br>
	<div class="cotn_principal">
		<div class="cont_centrar">

			<div class="cont_login">
				<div class="cont_info_log_sign_up">
					<div class="col_md_login">
						<div class="cont_ba_opcitiy">

							<h2>로그인</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<button class="btn_login" onclick="change_to_login()">로그인</button>
						</div>
					</div>
					<div class="col_md_sign_up">
						<div class="cont_ba_opcitiy">
							<h2>회원가입</h2>


							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>

							<button class="btn_sign_up" onclick="change_to_sign_up()">회원가입</button>
						</div>
					</div>
				</div>


				<div class="cont_back_info">
					<div class="cont_img_back_grey">
						<img
							src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
							alt="" />
					</div>

				</div>
				<div class="cont_forms">
					<div class="cont_img_back_">
						<img
							src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d"
							alt="" />
					</div>
					<div class="cont_form_login">
						<a href="#" onclick="hidden_login_and_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>로그인</h2>
						<input type="text" placeholder="Email" /> <input type="password"
							placeholder="Password" />
						<button class="btn_login" onclick="change_to_login()">로그인</button>
					</div>

					<div class="cont_form_sign_up">
						<a href="#" onclick="hidden_login_and_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>회원가입</h2>
						<input type="text" placeholder="이름" /> 
						<input type="text" placeholder="아이디" /> 
						<input type="text" placeholder="비밀번호" /> 
						<input type="password" placeholder="비밀번호 확인" />
						<input type="text" placeholder="주민등록번호" /> 
						<input type="text" placeholder="핸드폰번호" /> 
						<input type="text" placeholder="지역" /> 
						<input type="text" placeholder="부양가족 수" /> 
						<input type="text" placeholder="무주택기간" /> 
						<input type="text" placeholder="통장개설연도" /> 
						<input type="text" placeholder="결혼유무" /> 
						<input type="text" placeholder="평수선택" /> 
						<button class="btn_sign_up" onclick="change_to_sign_up()">회원가입</button>

					</div>

				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
</body>
</html>