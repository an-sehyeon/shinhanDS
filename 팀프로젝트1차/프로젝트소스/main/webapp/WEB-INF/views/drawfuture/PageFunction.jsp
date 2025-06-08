<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>인생설계 플랫폼 기능 안내</title>
  <%@ include file="../common/header.jsp"%>
<link rel="stylesheet" href="${cpath}/resources/css/future.css">
</head>
<body>
  <div class="container">
    <h1>2 Team Project 페이지 설계 / 기능</h1>
    <table>
    <thead>
        <tr>
            <th>페이지</th>
            <th>기능</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><a href="${cpath}/mapage.do">메인 페이지</a></td>
            <td>
                <ol>
                    <li>은행별 실시간 금리 확인(은행연합회 소비자포털)</li>
                    <li>분양 정보 및 청약 정보 제공(한국부동산원 청약홈에서 OpenAPI제공)</li>
                    <li>추천 금융 상품 및 서비스</li>
                    <li>추천수 높은 게시글 리스트</li>
                    <li>최근 인기 있는 목표 리스트</li>
                    <li>금융 관련 뉴스 및 트렌드 공유</li>
                    <li>사용자에게 힘을 주는 오늘의 명언 제공</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>인생 시뮬레이터 입력 페이지</td>
            <td>
                <ol>
                    <li>사용자 정보 입력 (나이, 직업, 소득, 관심 분야 등)</li>
                    <li>목표 설정 (주택 구매, 투자, 자녀 교육, 노후 준비, 여행, 자동차 구매 등)</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>전략 플랜 추천 페이지</td>
            <td>
                <ol>
                    <li>사용자 목표에 따른 재무 계획 솔루션 제공</li>
                    <li>목표 달성을 위한 단계별 전략 및 금융 상품 추천</li>
                    <li>목표 달성을 위한 예상 시나리오 제공</li>
                    <li>사용자의 월 소득, 자산, 부채 소비 패턴 분석 후 최적 자금 운용 플랜 또는 최대 운용 가능 자금 플랜 추천</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>통계 및 비교 페이지</td>
            <td>
                <ol>
                    <li>사용자와 같은 연령대 비교 차트</li>
                    <li>사용자와 같은 직업군 비교 차트</li>
                    <li>사용자와 같은 소득 수준 비교 차트</li>
                    <li>사용자와 같은 관심 분야 비교 차트</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>커뮤니티 &amp; Q&amp;A 게시판 페이지</td>
            <td>
                <ol>
                    <li>질문 게시판 - 사용자 질문 및 답변 게시판</li>
                    <li>유저 솔루션 공유 게시판 - 재무 계획 솔루션 공유, 좋아요/댓글 기능</li>
                    <li>정보 공유 게시판 - 금융 상품, 서비스, 투자 정보 공유</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>순위 페이지</td>
            <td>
                <ol>
                    <li>포인트, 좋아요 수, 기여도 기반 랭킹</li>
                    <li>개인 프로필에 목표 히스토리/성취율 표시</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>로그인/회원가입 페이지</td>
            <td>
                <ol>
                    <li>로그인 기능</li>
                    <li>회원가입 기능 - 사용자 정보 입력</li>
                    <li>아이디, 비밀번호 찾기 기능</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>마이페이지</td>
            <td>
                <ol>
                    <li>회원 정보 수정 기능</li>
                    <li>비밀번호 변경 기능</li>
                    <li>회원 탈퇴 기능</li>
                    <li>목표 설정 및 수정 기능</li>
                    <li>목표 달성 현황 확인 기능</li>
                    <li>포인트 및 기여도 확인 기능</li>
                    <li>사용자 맞춤형 목표 및 금융 상품 추천 기능</li>
                    <li>채팅 기록 확인 기능</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>관리자 페이지</td>
            <td>
                <ol>
                    <li>사용자 관리 기능 - 정보 조회, 수정, 삭제</li>
                    <li>게시판 관리 기능 - 게시글 삭제, 댓글 관리</li>
                    <li>포인트 및 기여도 관리 기능</li>
                    <li>오픈 채팅방 관리 기능</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>포인트 페이지</td>
            <td>
                <ol>
                    <li>포인트 사용 내역 확인 기능</li>
                    <li>포인트 적립 내역 확인 기능</li>
                    <li>포인트 사용 가능 서비스 리스트</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>채팅 페이지</td>
            <td>
                <ol>
                    <li >1대1 채팅 요청 및 알림</li>
                    <li>채팅 기록 확인 및 알림 기능</li>
                    <li>채팅 차단 및 신고 기능</li>
                    <li>오픈 채팅방 생성, 참여, 검색, 신고, 나가기 기능</li>
                </ol>
            </td>
        </tr>
    </tbody>
</table>
</div>
    <section>
        <h2>[추가 기능]</h2>
        <h3>1. 챗봇 기능</h3>
        <ol>
            <li>사용자 질문에 대한 자동 응답 기능</li>
            <li>금융 상품 및 서비스 추천 기능</li>
            <li>목표 설정 및 달성 관련 조언 제공</li>
            <li>커뮤니티 게시글 추천 기능</li>
        </ol>

        <h3>2. 포인트 제공 리스트</h3>
        <ol>
            <li>게시글 작성, 댓글 작성에 따라 포인트 지급</li>
            <li>목표 달성 시 포인트 지급</li>
            <li>커뮤니티 활동(좋아요), 추천수에 따른 포인트 지급</li>
            <li>상위 랭킹에 따른 포인트 지급</li>
        </ol>

        <h3>3. 포인트 사용 리스트</h3>
        <ol>
            <li>프리미엄 서비스 이용(고급 통계, 전문가 매칭 이용권 등)</li>
            <li>채팅 기능 이용(1대1 채팅, 오픈 채팅방 참여 등)</li>
            <li>커뮤니티 게시글 상위 노출</li>
            <li>특별 이벤트 참여권 제공</li>
            <li>룰렛, 경품 추첨 참여권 제공(포인트를 많이 쓸수록 확률 증가)</li>
        </ol>
    </section>
</body>
</html>