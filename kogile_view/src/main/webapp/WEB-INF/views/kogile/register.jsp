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
<title>Register</title>
</head>
<body class="bg-dark">
	<div class="card card-login mx-auto mt-5">
		<div class="card-body">
		<legend>Create a Kogile Account</legend><br>
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
						<input type="text" id="inputName" class="form-control"
							placeholder="Name" required="required" autofocus="autofocus">
						<label for="inputName">Name</label>
					</div>
				</div>
				<div class="form-group">
					<div class="form-label-group">
						<input type="password" id="inputPassword" class="form-control"
							placeholder="Password" required="required"> <label
							for="inputPassword">Password</label>
					</div>
				</div>
				<a class="btn btn-primary btn-block" id="registerIntermem" href="/kogile/register">Create New Account</a> <br>
				<a class="btn btn-warning btn-block"
					href="/login/external/registerKogileWithKakao">Sign up With Kakao</a>
			</form>
			<div class="text-center">
				<a class="d-block small mt-3" href="/kogile/login">Login</a>
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
	<script>
	$(function(){
		$('#registerIntermem').on('click', function(){
			var email = $('#inputEmail').val();
			var password = $('#inputPassword').val();
			var name = $('#inputName').val();
			userService.register({name: name, email: email, password: password}, function(){
				alert("가입되었습니다.");
			});
			return false;
		})
	})
	</script>

</body>
</html>