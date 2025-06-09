<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지 설명</title>
<style>
  body {
    margin: 0;
    background: black;
    overflow: hidden;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
    color: white;
    font-family: 'Arial', sans-serif;
  }

  .ghost-container {
    position: absolute;
    top: -50%;
    left: 50%;
    transform: translateX(-50%) scale(0.8);
    opacity: 0.5;
    filter: blur(5px);
    animation: emerge 6s ease-in-out forwards;
    z-index: 1;
  }

  @keyframes emerge {
    0% {
      transform: translateX(-50%) translateY(-100%) scale(0.8);
      opacity: 0.1;
      filter: blur(5px);
    }
    50% {
      transform: translateX(-50%) translateY(0%) scale(1.0);
      opacity: 0.6;
      filter: blur(2px);
    }
    100% {
      transform: translateX(-50%) translateY(50%) scale(1.4);
      opacity: 1;
      filter: blur(0px);
    }
  }

  .ghost-container:hover {
    animation: emergeFast 2s ease-in-out forwards;
  }

  @keyframes emergeFast {
    0% {
      transform: translateX(-50%) translateY(0%) scale(1.0);
      opacity: 0.5;
    }
    100% {
      transform: translateX(-50%) translateY(70%) scale(1.6);
      opacity: 1;
    }
  }

  .main-text {
    z-index: 2;
    font-size: 45px;
    text-align: center;
    color: #fff;
    text-shadow: 0 0 15px red;
    position: relative;
  }
</style>
<%@ include file="../common/header.jsp"%>
</head>
<body>
  <div class="ghost-container">
    <img class="ghost" src="${cpath}/resources/images/귀신-png.webp" alt="Ghost Face">
  </div>

  <div class="main-text">
    <h1>${name}님<br>염탐하지 마시죠?</h1>
  </div>
</body>
</html>
