
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="/resources/css/main.css" rel="stylesheet">
<title>프로젝트 상세보기</title>
</head>
<body id="page-top">
	<input id="rw2" type="hidden" value="${pjt_no}" name="pjt_no">
	<input id="rw" type="hidden" value="${total_m_no}" name="total_m_no">

	<%@ include file="../../includes/nav.jsp"%>

	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="../../includes/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> 프로젝트 정보
					</div>

					<div class="card-body">
						<form action="" name="project_info" method="post">
							<input type="hidden" name="pjt_no" value="${project.pjt_no}">

							<div id="pjt_title">
								<h4>
									<b>프로젝트 명</b>
								</h4>
								<input type="text" name="pjt_title" class="form-control"
									value="${project.pjt_title }"> <br>
							</div>


							<div id="pjt_contents">
								<h4>
									<b>설명</b>
								</h4>
								<input type="text" name="pjt_contents" class="form-control"
									value="${project.pjt_contents }"> <br>
							</div>

							<div id="pjt_date">
								<h4>
									<b>생성일</b>
								</h4>
								<p><fmt:formatDate value="${project.pjt_date}" pattern="yyyy-MM-dd"/></p>

							</div>
	
							<div id="master_info">
								<h4>
									<b>프로젝트 마스터</b>
								</h4>
								<span class="name" style="margin-right: 5px;">${master.name.substring(master.name.length()-2)}</span>
								<p style="margin: 0px;">${master.name }</p>
								<a>${master.mail }</a> <br> <br>

							</div>
						</form>

						<div class="dropdown-divider"></div>
						<!-- end description -->
						<a id="modify_pjt" href="#" class="btn btn-warning"
							data-toggled="modal" data-target="#delete_project">수정</a> 
						<a id="delete_pjt" href="#" class="btn btn-danger"
							data-toggled="modal" data-target="#delete_project">프로젝트 삭제</a>
							<input class="btn btn-default" class="exitPjt"id="exitPjt" type="button" value="퇴장" style="position: absolute; right: 10px;">
				</div>
				<!-- end card body -->
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
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
		<%@ include file="../../includes/content_footer.jsp"%>


	</div>
	<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->



	<%@ include file="../../includes/footconfig.jsp"%>
	<script src="/resources/js/main_config.js"></script>
	
</body>
</html>