<%@page import="kogile.user.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/css/profile.css" rel="stylesheet">
<link href="/resources/css/common.css" rel="stylesheet">
<!-- <script src="/resources/vendor/jquery/jquery.min.js"></script> -->
<!-- <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script> -->
<!-- <script src="/resources/js/main.js"></script> -->

<!-- 김근열 js소스  -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- <script src="/resources/js/common.js"></script>	 -->
<!-- <script type="text/javascript">
console.log("========");
console.log("js test");
function yesNo(){
	var a = confirm("초대하시겠습니까?");
	if(a==true){
		alert("초대됐습니다.");
		}
	else{
		alert("초대가 취소됐습니다.");	
		return false;
	}
}
>>>>>>> refs/heads/cyr

<<<<<<< HEAD
=======
var searchListService = (function() {

	function searchList(param, callback, error) {

		var search = param.search;
		
		$.getJSON("/invite/searchList/" + search + ".json", 
	
		function(data) {
			if (callback) {
				callback(data);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	return {
		searchList : searchList 
	};
})();
$(function(){
$("#btn-search").on('click', function(e) {
	  e.preventDefault();
	 
	var searchValue = $('input[name=search]').val();
	var searchUL = $(".chat");
	
	  console.log(searchValue);
	
	searchListService.searchList({search:searchValue}, function(list){
			
			var value = "";
			
			if(list == null || list.length == 0){
				searchUL.html("");
				
				return;
			}
				for(var i = 0; i<list.length; i++){
				
					value += "<p><input class='btn btn-default' type='submit' value='" +  list[i].no + " " + list[i].name + " " + list[i].mail 
					  + "'data-toggle='button' onclick='return yesNo()'/>";
		
				}
				
				$('[data-toggle="popover"]').popover({
					html : true,
					placement : 'bottom'
				});
				
				$('#btn-search').attr("data-content", value);
			
		});
});
});


</script> -->
</head>
<body>

	<%
		UserVO user = (UserVO)session.getAttribute("user");
	%>
	
	<%@ include file="profile_modal.jspf" %>
	

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="/kogile/startPage">Kogile</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form method='get' id="search_form"
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" name="search"
					placeholder="Search for..." value="" />
				<div class="input-group-append">
					<button type="button" class="btn btn-primary" id="btn-search"
						data-toggle="popover">
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
					<span class="badge badge-danger" id="noticeLength" ></span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="alertsDropdown" id="notice3">
					<!-- <p class="dropdown-item notice_list" href="#">action</p>
					<a class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a> -->
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

					<div class="dropdown-item">반갑습니다. <%=user.getName() %> 님.</div>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#"
					data-toggle="modal" data-target="#profile_modal">Profile</a>
					
					<!-- <a class="dropdown-item" href="/kogile/register">Register</a> -->
					<c:choose>
						<c:when test="${empty user}">
							<a class="dropdown-item" href="/kogile/login">Login</a>
						</c:when>
						<c:otherwise>
							<a class="dropdown-item" href="/kogile/logout">Logout</a>
						</c:otherwise>
					</c:choose>
				</div></li>
		</ul>

	</nav>
</body>

</html>