<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="vo" varStatus="status">
	<div class="list_border">
		<div class="img_wrap">
			<img class="missing_img" alt="pet" src="../resources/img/${vo.img}">
		</div>
		<ul>
			<li class="missing_infoList"><a href="boardDetail?missingId=${vo.missingId}">${vo.title}</a></li>
			<li class="missing_infoList">지역 : ${vo.location}</li>
			<li class="missing_infoList">종류 : ${vo.pet}</li>
			<li class="missing_infoList">사례금 : ${vo.gratuity}원</li>
		</ul>
	</div>
</c:forEach>