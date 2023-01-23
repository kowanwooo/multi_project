<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/market.css" rel="stylesheet">
<script type="text/javascript" src="../resources/js/jquery-3.6.1.js"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=mcn4h7vwlk&submodules=geocoder,panorama"></script>
<script type="text/javascript">
	$(function() {
		
		var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주특별자치도"];
		  var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
		   var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
		   var area3 = ["대덕구","동구","서구","유성구","중구"];
		   var area4 = ["광산구","남구","동구","북구","서구"];
		   var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
		   var area6 = ["남구","동구","북구","중구","울주군"];
		   var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
		   var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
		   var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
		   var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
		   var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
		   var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
		   var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
		   var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
		   var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
		   var area16 = ["서귀포시","제주시","남제주군","북제주군"];
		 // 시/도 선택 박스 초기화
		 $("select[name^=sido]").each(function() {
		  $selsido = $(this);
		  $.each(eval(area0), function() {
		   $selsido.append("<option value='"+this+"'>"+this+"</option>");
		  });
		  $selsido.next().append("<option value=''>구/군 선택</option>");
		 });
		 // 시/도 선택시 구/군 설정

		 $("select[name^=sido]").change(function() {
		  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
		  var $gugun = $(this).next(); // 선택영역 군구 객체
		  $("option",$gugun).remove(); // 구군 초기화

		  if(area == "area0"){
		   $gugun.append("<option value=''>구/군 선택</option>");
		  }
		  else {
			$gugun.append("<option value=''>구/군 선택</option>");
		   $.each(eval(area), function() {
		    $gugun.append("<option value='"+this+"'>"+this+"</option>");
		   });
		  }
		 });
		 $("select[name^=sido]").click(function() {
			 search();
		 })
		 $("select[name^=gugun]").change(function() {
			search();
		 })
		
		 <%String sido = null;
		String gugun = null;
			if (session.getAttribute("address") != null) {
				sido = session.getAttribute("address").toString().split(" ")[0];
				gugun = session.getAttribute("address").toString().split(" ")[1];
				switch(sido){
				case "서울":
					sido = "서울특별시";
				break;
				case "인천":
					sido = "인천광역시";
				break;
				case "대전":
					sido = "대전광역시";
				break;
				case "광주":
					sido = "광주광역시";
				break;
				case "대구":
					sido = "대구광역시";
				break;
				case "울산":
					sido = "울산광역시";
				break;
				case "부산":
					sido = "부산광역시";
				break;
				case "경기":
					sido = "경기도";
				break;
				case "강원":
					sido = "강원도";
				break;
				case "충북":
					sido = "충청북도";
				break;
				case "충남":
					sido = "충청남도";
				break;
				case "전북":
					sido = "전라북도";
				break;
				case "전남":
					sido = "전라남도";
				break;
				case "경북":
					sido = "경상북도";
				break;
				case "경남":
					sido = "경상남도";
				break;
				}
			}%> 
			
			if("<%=session.getAttribute("address")%>" != "null"){
				
				$('#sido1').val("<%=sido%>").prop("selected", true).trigger("change");
				$('#gugun1').val("<%=gugun%>").prop("selected", true).trigger("change");
				
				
				// 사용자의 회원 정보에 등록된  주소에 따라 지역 셀렉트박스 옵션 설정
			} else{
				$('#sido1').val("시/도 선택").prop("selected", true).trigger("change");
				$('#gugun1').val("").prop("selected", true).trigger("change");
			}
			search();
			
		$('#b1').click(function() {
			search();
		})//b1
		
	})//func

	function search() {
		$.ajax({
			url : "searchByCategory",
			data : {
				pageNumber : 1,
				region : $('#sido1').val()+" "+$('#gugun1').val(),
				category : $('#category').val(),
				keyword : $('#keyword').val(),
				pageSize : $('#pageSize').val()
			},
			success : function(x) {
				$('#result').html(x)
			}
		})
	}//function search()
	
</script>
</head>
<body>
<jsp:include page="../header/animal_header.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<br>
<div class="marketHomeDiv">
	<a href="./insert.jsp" style="margin-left: 520px"><button class="marketButton">판매글
			작성</button></a>
	<a
		href="../message/chatRoomList?sessionId=<%=session.getAttribute("userId")%>"
		style="margin-left: 20px;"><button class="pointButton">채팅함</button></a>
	<br>
	<br>
	<select name="sido1" id="sido1"></select>
	<select name="gugun1" id="gugun1"></select>
	<select id="category" onchange="search()">
		<option value="전체">물품 유형</option>
		<option value="놀이기구">놀이기구</option>
		<option value="의류">의류</option>
		<option value="음식">음식</option>
		<option value="관리용품">관리용품</option>
		<option value="집">집</option>
		<option value="기타">기타</option>
	</select>
	<input id="keyword">
	<button id="b1" class="marketButton">검색</button>
	<select id="pageSize" onchange="search()">
		<option value="5">게시물 5개씩 보기</option>
		<option value="10">게시물 10개씩 보기</option>
		<option value="20">게시물 20개씩 보기</option>
		<option value="50">게시물 50개씩 보기</option>
	</select>
	<br>
	<br>
	<div id="result"></div>
	<div id="map"></div>
	</div>
</body>
</html>