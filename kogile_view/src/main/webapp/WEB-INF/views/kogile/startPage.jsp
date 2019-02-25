<%@page import="kogile.user.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="/resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin.css" rel="stylesheet">
<link href="/resources/css/startPage.css" rel="stylesheet">
<title>startPage</title>
</head>
<body id="page-top">
	<!-- include -->
	<%@ include file="../includes/nav.jsp"%>
	<%@ include file="../includes/insert_Project_modal.jsp" %>
	<!-- include end -->
	
	<!-- hidden param -->
	<input id="rw" type="hidden" value="<%= user.getTotal_m_no() %>" name="total_m_no">
	
	<div id="wrapper">

		<!-- Sidebar -->
		<%-- <%@ include file="../includes/sidebar.jsp"%> --%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<!-- <i class="fas fa-table"></i> Data Table Example -->
						<b>Project List</b>
					</div>
					<!-- star card body -->
					<div class="card-body">
					
					<!-- <div class="MYcontents"> -->
						<a id="insertProjectForm" class="btn btn-primary" href="#"
						data-toggle="modal" data-target="#insert_Porject_modal">프로젝트
							생성</a>
						<ul class="MYcreate" id="pjt">
							<!-- <li><a href="#">sss</a></li> -->
							<%-- <c:if test="${project_list != null }">

								<c:forEach var="Project" items="${project_list}">
									<li><a href="detailProject.pjt?pjt_no=${Project.pjt_no}">${Project.pjt_title}</a>
									</li>
								</c:forEach>
							
							</c:if> --%>
						</ul>
					<!-- </div> -->
					</div>
					<!-- end card body -->
					
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

				<!-- <div class="card card-login mx-auto mt-5">
					<div class="card-header">Login</div>
					<div class="card-body">
						<form>
							<div class="form-group">
								<div class="form-label-group">
									<input type="email" id="inputEmail" class="form-control"
										placeholder="Email address" required="required"
										autofocus="autofocus"> <label for="inputEmail">Email
										address</label>
								</div>
							</div>
							<div class="form-group">
								<div class="form-label-group">
									<input type="password" id="inputPassword" class="form-control"
										placeholder="Password" required="required"> <label
										for="inputPassword">Password</label>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox" value="remember-me">
										Remember Password
									</label>
								</div>
							</div>
							<a class="btn btn-primary btn-block" href="index.html">Login</a>
						</form>
						<div class="text-center">
							<a class="d-block small mt-3" href="register.html">Register
								an Account</a> <a class="d-block small" href="forgot-password.html">Forgot
								Password?</a>
						</div>
					</div>
				</div> -->

				<!--         <p class="small text-center text-muted my-5">
          <em>More table examples coming soon...</em>
        </p> -->

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<%@ include file="../includes/content_footer.jsp"%>


		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->



	<%@ include file="../includes/footconfig.jsp"%>
	<script src="/resources/js/startPage.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#messagesDropdown").parent().hide();
	})
	</script>
</body>

</html>