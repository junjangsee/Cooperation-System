<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%
	 	int pjt_no = -1;
	 	if(session.getAttribute("pjt_no") != null){
	 		pjt_no = (int)session.getAttribute("pjt_no");
	 	}
	 %>

	<c:set var="pjt_no"><%=pjt_no %></c:set>

	    <ul class="sidebar navbar-nav toggled">
      <li class="nav-item">
        <a class="nav-link" href="/kogile/main?pjt_no=${pjt_no}">
          <i class="fas fa-fw fa-folder"></i>
          <span>Board</span>
        </a>
      </li>
<!--       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class=""></i>
          <span>Pages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Login Screens:</h6>
          <a class="dropdown-item" href="login.html">Login</a>
          <a class="dropdown-item" href="register.html">Register</a>
          <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Other Pages:</h6>
          <a class="dropdown-item" href="404.html">404 Page</a>
          <a class="dropdown-item" href="blank.html">Blank Page</a>
        </div>
      </li> -->
     
     <!-- chart -->
     <!--  <li class="nav-item dropdown">
	  <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span>
      </a>
      <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Login Screens:</h6>
          <a class="dropdown-item" href="#">메뉴1</a>
          <a class="dropdown-item" href="#">메뉴2</a>
          <a class="dropdown-item" href="#">메뉴3</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Other Pages:</h6>
          <a class="dropdown-item" href="404.html">404 Page</a>
          <a class="dropdown-item" href="blank.html">Blank Page</a>
        </div>
      
      </li> -->
      <!-- end chart -->
      
      <li class="nav-item">
        <a class="nav-link" href="/kogile/board/list?pjt_no=${pjt_no}" id="btn_body_board">
          <i class="fas fa-fw fa-table"></i>
          <span>공지사항</span></a>
      </li>
      
    	<li class="nav-item">
	        <a class="nav-link" href="/kogile/project/config?pjt_no=${pjt_no}" id="btn_body_configure">
	          <i class="fas fa-fw fa-tachometer-alt"></i>
	          <span>정보/설정</span>
	        </a>
     	</li>
    </ul>
</body>
</html>