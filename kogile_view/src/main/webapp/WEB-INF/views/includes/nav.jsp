<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 김근열 js소스  -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <script src="/resources/vendor/jquery/jquery.min.js"></script> -->
<!-- <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script> -->
<!-- <script src="/resources/js/main.js"></script> -->

<!-- 190214 김근열 추후 취합 후 삭제 -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/js/search.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var searchValue = 'sohee';
	var searchUL = $(".chat");
	
	function a(){
	searchListService.searchList({search:searchValue}, function(list){
			
			var str="";
			if(list == null || list.length == 0){
				searchUL.html("");
				
				return;
			}
				for(var i = 0, len = list.length||0; i<len; i++){
					str +="<li class='left clearfix' data-rno='"+list[i].no+"'>";
					str +="<div><div class='header'><strong class='primary-font'>"
						+list[i].name+"</strong>";
					str +=" <small class='pull-right text-muted'>" + list[i].mail + "</small>";
				}
				
				searchUL.html(str);
			});
	
});
	

</script>

</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">


		<a class="navbar-brand mr-1" href="/kogile/startPage">Kogile</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		
		<!-- Navbar Search -->
		<form method='get' action="/invite/searchList" id="search_form"
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" name="search" value=""/>
				<div class="input-group-append">
					<button type="submit" class="btn btn-primary" ><!--  id="btn-search"
					data-toggle="popover" data-trigger="focus" data-content="ss"> -->
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		
		<!-- 채팅창 띄우기. -->
		<!-- <script src="/resources/js/chat.js"></script> -->
		<!-- Navbar -->
		
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- 알림 -->
					<!-- <span class="badge badge-danger">9+</span> -->
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="alertsDropdown">
					<p class="dropdown-item notice_list" href="#">action</p>
					<a class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <!-- 메일 -->
					<!-- <span class="badge badge-danger">7</span> -->
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="messagesDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a> <a
						class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>
	
	
	<!-- 검색 목록 화면처리 나중에 pop오버에 값 넣어야한다..190214 김근열 --> 	
		 	<div class="panel-body">
		 		<ul class="chat">
		 		
		 		</ul>
		 	</div>
		 

		

</body>
</html>