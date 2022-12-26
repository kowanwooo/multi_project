<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="vo" varStatus="status">
	<div class="list_border">
		<div class="img_wrap">
			<img class="missing_img" alt="pet" src="resources/img/${vo.img}">
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
<hr color="red">
<%
	int pages = (int)request.getAttribute("pages");
	for(int p = 1; p <= pages; p++){
%>
	<a href=fetchBoard?page=<%= p %>>
		<button style="background: lime; color: red; width: 50px;"><%= p %></button>
	</a>  
<%		
	}
%>