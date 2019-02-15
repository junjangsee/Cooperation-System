 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="/resources/css/main_post.css" rel="stylesheet">
<title>Login</title>
</head>
<body id="page-top">
	
	<%@ include file="../../includes/nav.jsp"%>

	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="../../includes/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i>  ${post.p_title}
					</div>
					
					<div class="card-body">
					
						<div class="right_list">
							<div class="addcard_holder holder">
								<h3 class="title_c">ADD TO CARD</h3>
								<div class="btn_list">
									<a href="#" class="mem_btn">Members</a> 
									<a id="MY_btn_label" href="#" class="label_btn"  role="button" data-toggle="popover" data-trigger="focus" title="Label" data-content="">Labels</a> 
									<a href="#" class="check_btn">Checklist</a>
									<a href="#" class="due_btn">Due Date</a> 
									<a href="#" class="atta_btn">Attachment</a>
								</div>
							</div>
						</div>
					
						<form name="post_info">
							
							<div style="width: 30%; float:left; margin-right: 10px;">
							<h4><b>포스트 명</b></h4>
							<input class="form-control" value="${post.p_title}"><br>
							</div>
							
							<c:set var="d_day"><fmt:formatDate value="${post.p_dday }" pattern="yyyy-MM-dd"/></c:set>
							
							<h4><b>마감일</b></h4>
							<input class="form-control" style="width: 30%"
							value="${d_day}" ><br>
							
							<div>
							<h4><b>설명</b></h4>
							<textarea name="description" class="add_input">${post.p_description}</textarea><br>
							</div>
							
							<h4><b>담당자</b></h4>
							<br>
							<br>
							
							<h4><b>라벨</b></h4>
							<br>
							<br>
							
							<h4><b>체크리스트</b></h4>
							<br>
							<br>
							
							
						</form>
						
					</div>
					<!-- end card-body -->
					<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
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
	<script src="/resources/js/detailPost.js"></script>

</body>
</html>