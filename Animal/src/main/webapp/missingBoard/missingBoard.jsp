<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실종 페이지</title>

<link rel="stylesheet" href="../resources/css/missingBoard.css">
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/style.css">
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "fetchBoard",
			success : function(table) {
				$("#result").html(table)
				/*alert('gg')  */
			}
		})

		$.ajax({
			url : "pageCount",
			success : function(table) {
				$("#result2").html(table)
			}
		})
	});
</script>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<div class="missing_container">
		<div class="missing_header">
			<h1 class="missing_title">실종 목록</h1>
			<span>실종 동물 검색</span> <select name="choice_pet">
				<option value="dog" selected>강아지</option>
				<option value="cat">고양이</option>
				<option value="another">기타 반려동물</option>
			</select> <select name="choice_location">
				<option value="seoul" selected>서울</option>
				<option value="busan">부산</option>
				<option value="daegu">대구</option>
				<option value="incheon">인천</option>
				<option value="gwangju">광주</option>
				<option value="daejeon">대전</option>
				<option value="ulsan">울산</option>
				<option value="ganwondo">강원도</option>
				<option value="jeju">제주도</option>
			</select>
			<button class="searh_btn">검색</button>
			<button class="create_btn" onclick = "location.href='missingBoardInsert.jsp'">등록하기</button>
		</div>
		<div id="result"></div>
		<div id="result2"></div>
	</div>
</body>
</html>