<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="vo" varStatus="status">
	<div class="list_border">
		<div class="img_wrap">
			<img class="missing_img" alt="pet" src="../resources/img/${vo.img}">
		</div>
		<ul>
			<li>${status.count}</li>
			<li>${vo.missingId}</li>
			<li>${vo.userId}</li>
			<li>${vo.title}</li>
			<li>${vo.location}</li>
			<li>${vo.tel}</li>
		</ul>
	</div>
</c:forEach>
