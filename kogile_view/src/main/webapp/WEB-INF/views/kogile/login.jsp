<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Login</title>
</head>
<body class="bg-dark">
	<div class="card card-login mx-auto mt-5">
		<div class="card-body">
			<legend>Log in to Kogile</legend>
			<br>
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
				<a class="btn btn-primary btn-block" href="#" id="loginIntermem">Login</a><br>
				<a class="btn btn-warning btn-block"
					href="/login/external/loginKogileWithKakao">Login With Kakao</a>
			</form>
			<div class="text-center">
				<a class="d-block small mt-3" href="register.html">Register an
					Account</a>
			</div>
		</div>
	</div>

	<!--         <p class="small text-center text-muted my-5">
          <em>More table examples coming soon...</em>
        </p> -->

	</div>
	<!-- /.container-fluid -->

	<!-- Sticky Footer -->


	</div>
	<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->


	<%-- <%@ include file="../includes/content_footer.jsp"%> --%>

	<%@ include file="../includes/footconfig.jsp"%>
	<script src="/resources/js/user.js"></script>
	<script src="/resources/js/boundsChecking.js"></script>
	<script>
		$(function() {
			
			$(document).on('blur', 'input', function(){
				var type = this.getAttribute('id');
				
				switch(type){
					case 'inputEmail':
						console.log('email');
					break;
				}
			});
			
			$('#loginIntermem').on('click', function() {
				var email = $('#inputEmail').val();
				var password = $('#inputPassword').val();
				userService.login({
					email : email,
					password : password
				}, function() {
					location.href = "/kogile/startPage";
				}, function(er) {
					alert("이메일과 비밀번호를 를 확인해주세요.");
				});
				return false;
			})
		})
	</script>

</body>
</html>