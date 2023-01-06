<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/missingBoardDetail.css">
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
	<jsp:include page="../../../header/header.jsp"></jsp:include>
	<div class="detail_container">
		<div class="detail_header">
			<h1 class="detail_title">우리아이를 찾습니다!!</h1>
			<button class="end_btn">실종종료</button>
		</div>
		<div class="detail_imgWrap">
			<div class="detail_mainImg">
				<img class="detail_img" alt="pet" src="../resources/upload/${one.img}">
			</div>
		</div>
		<div class="detail_infoWrap">
			<div class="detail_info">
				<div class="detail_btn">
					<button>수정하기</button>
					<button>삭제하기</button>
				</div>
				<div class="detail_list">
					<ul>
						<li>보호자 연락처 : ${one.tel}</li>
						<li>잃어버린 장소 : ${one.location}</li>
						<li>잃어버린 날짜 : ${one.missingDate}</li>
					</ul>
					<div>
						<div class="detail_subImg">이미지</div>
						<div class="detail_subImg">이미지2</div>
					</div>
				</div>
				<div class="detail_list2">
					<ul>
						<li>글제목 : ${one.title}</li>
						<li>상세설명 : ${one.description}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>