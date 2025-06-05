<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="path" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${path}/resources/css/chatting.css" />
<script  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="EnterOut_div">
			<input type="text" id="user" class="form-control" placeholder="유저명">
			<button type="button" class="btn btn-default enter_Btn"
				id="btnConnect">연결</button>
			<button type="button" class="btn btn-default out_Btn"
				id="btnDisconnect" disabled>종료</button>
		</div>
		<div id="chat"></div>
		<div class="input_Btn input_wrap">
			<input type="text" name="msg" id="msg" placeholder="대화 내용을 입력하세요."
				class="form-control" disabled>
			<button class="btn_send">전송</button>
		</div>
	</div>
	<script>
		var ws; //웹소켓 변수 선언
		$('#btnConnect').on("click", f_connect);
		function f_connect() {				
				if ($('#user').val().trim() == '') {
					alert('유저명을 입력하세요.');
					$('#user').focus(); return;
				}
 				ws = new WebSocket("ws://" + location.host + "/${path}/chatserver");						
				ws.onopen = f_open;
				ws.onmessage = f_message;
				ws.onclose = function(evt) { console.log('소켓이 닫힙니다.');   };
				ws.onerror = function(evt) {	console.log(evt.data);  };		 
		}
	 
		function f_message(event) {
			try {
				const data = JSON.parse(event.data);
				switch (data.type) {
					case "chat":
						printOther(data.user, data.message); // 타인 메시지
						break;
					case "my":
						print(data.user, data.message); // 본인 메시지 (서버에서 보낼 경우)
						break;
					case "notice":
						printNotice(data.message); // 시스템 메시지 (입장 알림 등)
						break;
					default:
						console.warn("알 수 없는 메시지 유형:", data.type);
				}
			} catch (e) {
				console.error("메시지 파싱 오류:", e);
			}
		}
		function printNotice(msg) {
			let temp = '<div class="coming_user">' + msg + '</div>';
			$('#chat').append(temp);
		}
		// 메세지 전송 및 아이디
		function print(user, txt) {
			if (txt.trim() == '') { return;  	}
			let temp = '';
			temp += '<div class="message_container">';
			temp += ' <span style="font-size:12px;color:#777;margin-bottom: 3px;">'
					+ new Date().toLocaleTimeString([], {
						hour : '2-digit',
						minute : '2-digit'
					}) + '</span>';
			temp += '<div class="message_background">';
			temp += '<div class="message">';
			temp += txt;
			temp += '</div>';
			temp += '</div>';
			temp += '</div>';
			$('#chat').append(temp);
		}

		// 다른 client 접속
		var isFirstMessage = {}; // 각 사용자가 처음으로 메시지를 보냈는지 저장하는 객체
		function printOther(user, txt) {
			if (txt.trim() == '') {	return;  }
			let temp = '';
			if (!isFirstMessage[user]) { // 사용자가 처음으로 메시지를 보냈을 때만 입장 메시지를 출력
				temp += '<div class="coming_user">';
				temp += "'" + user + "' 이(가) 접속했습니다.";
				temp += '</div>';
				isFirstMessage[user] = true;
			}
			temp += '<div class="yourChat_message">';
			temp += '🍟' + user;
			temp += '<div class="your_message_background">';
			temp += '<div class="your_message">' + txt + '</div>';
			temp += ' <span style="font-size:12px;color:#777;margin-bottom: 3px;">'
					+ new Date().toLocaleTimeString([], {
						hour : '2-digit',
						minute : '2-digit'
					}) + '</span>';
			temp += '</div>';
			temp += '</div>';
			$('#chat').append(temp);
		}

		function f_open(evt){
    	    console.log("onopen 핸들러");
    	    const joinMessage = {
    	        type: "join",
    	        user: $('#user').val(),
    	        message: ""
    	    };
    	    ws.send(JSON.stringify(joinMessage)); // 서버에 JSON 형태로 전송
			$('#user').attr('readonly', true); //이미 접속한 유저명 수정 못하게 막기
			$('#btnConnect').attr('disabled', true); //연결 되었으니 연결 버튼 비활성화
			$('#btnDisconnect').attr('disabled', false); //종료 버튼 활성화
			$('#msg').attr('disabled', false); //메시지 입력 활성화
      }
		
		$('#user').keydown(function() {
			if (event.keyCode == 13) {
				$('#btnConnect').click();
			}
		});
		//서버에게 메시지 전달
		$(".btn_send").on("click", function() {
			f_messageSend();
		});

		$('#msg').keydown(function(event) {
			if (event.keyCode == 13) {			
				f_messageSend();
			}
		});
        function f_messageSend() {
        	let message = $("#msg").val().trim();
        	if (!message) return;
        	const msgObj = {
        		type: "chat",
        		user: $('#user').val(),
        		message: message
        	};
        	ws.send(JSON.stringify(msgObj));
        	print($('#user').val(), message); // 본인 메시지 즉시 출력
        	$('#msg').val('').focus();
        }
		
		$('#btnDisconnect').click(function() {
			 const leaveMessage = {
				        type: "leave",
				        user: $('#user').val(),
				        message: ""
				    };
			ws.send(JSON.stringify(leaveMessage)); // 퇴장 메시지 서버로 전송
			ws.close();
			$('#user').attr('readonly', false);
			$('#user').val('');
			$('#btnConnect').attr('disabled', false);
			$('#btnDisconnect').attr('disabled', true);
			$('#msg').val('');
			$('#msg').attr('disabled', true);
		});

		function rand(min, max) {
			return Math.floor(Math.random() * (max - min + 1)) + min;
		}
		$(function() {
			var aa = rand(1, 15);
			$("#chat").css(
							{
								"background-image" : `url("${path}/resources/images/chat_bg\${aa}.jpg")`
							});
		});
	</script>
</body>
</html>
