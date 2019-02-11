<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kogile</title>
</head>
<body>

	<div class="card-body add_card-body" id="body_configure">
		<form action="" name="project_info" method="post">
		<input type="hidden" name="pjt_no" value="">
		
		<div id="pjt_title">
			<h4>
				<b>프로젝트 명</b>
			</h4>
			<input type="text" name="pjt_title" class="form-control" value="">
			<br>
		</div>
		
		
		<div id="pjt_contents">
			<h4>
				<b>설명</b>
			</h4>
			<input type="text" name="pjt_contents" class="form-control" value="">
			<br>
		</div>
		
		<div id="pjt_date">
			<h4>
				<b>생성일</b>
			</h4>
			<p></p>
			
		</div>
		
		<div id="master_info">
			<h4><b>프로젝트 마스터</b></h4>
			<span class="name" style="margin-right: 5px;"></span>
			<p style="margin: 0px;"></p>
			<a></a>
			<br>
			<br>
			
		</div>
		</form>
		
		<div class="dropdown-divider"></div>
		<!-- end description -->
		<a id="modify_pjt" href="#" class="btn btn-warning" data-toggled="modal"
			data-target="#delete_project">수정</a>
		<a id="delete_pjt" href="#" class="btn btn-danger" data-toggled="modal"
			data-target="#delete_project">프로젝트 삭제</a>
	</div>
	<!-- end cardbody -->

</body>
</html>