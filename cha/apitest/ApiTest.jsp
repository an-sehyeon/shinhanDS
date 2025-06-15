<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- sms.html -->
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>SMS 인증 테스트</title>
</head>
<body>
  <h2>휴대폰 인증</h2>
  <input type="text" id="phoneNumber" placeholder="01012345678">
  <button onclick="sendSms()">인증번호 전송</button>

  <script>
    function sendSms() {
      const phoneNumber = document.getElementById('phoneNumber').value;

      fetch('/spring/sms/send-sms', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ to: phoneNumber })
      })
      .then(response => response.text())
      .then(data => {
        alert('서버 응답: ' + data);
      })
      .catch(error => {
        console.error('에러 발생:', error);
        alert('인증번호 전송 실패');
      });
    }
  </script>
</body>
</html>
