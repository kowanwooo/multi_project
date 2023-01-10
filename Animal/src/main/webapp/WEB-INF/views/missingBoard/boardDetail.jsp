<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/missingBoardDetail.css">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".searh_btn").on("click",	function() {
			$.ajax({
					url : "searchFilter",
					data : {
						pet : $("select[name=choice_pet] option:selected").text(),
						location : $("select[name=choice_location] option:selected").text(),
							},
					success : function(table) {
						$("#result").html(table)
					}
				})
		})
	});
</script>
</head>
<body>
	<jsp:include page="../../../header/header.jsp"></jsp:include>
	<div class="detail_container">
		<div class="detail_header">
			<h1 class="detail_title">우리아이를 찾습니다!!</h1>
			<button class="end_btn" onclick="location.href='missingEnd?missingId=${one.missingId}'">실종종료</button>
		</div>
		<div class="detail_imgWrap">
			<div class="detail_mainImg">
				<c:if test="${one.rule eq 1}">
					<img class="missingDetailEnd_img" alt="end" src="../resources/img/실종종료.png">
				</c:if>
				<img class="detail_img" alt="pet"
					src="../resources/upload/${one.img}">
			</div>
		</div>
		<div class="detail_infoWrap">
			<div class="detail_info">
				<div class="detail_btn">
					<button class="modify_btn" onclick="location.href='findOne?missingId=${one.missingId}'">수정하기</button>
					<button class="delete_btn"  onclick="location.href='delete?missingId=${one.missingId}'">삭제하기</button>
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