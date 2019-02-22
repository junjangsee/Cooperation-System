<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="/resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/resources/css/sb-admin.css" rel="stylesheet">
<link href="/resources/css/main.css" rel="stylesheet">
<style type="text/css">

</style>
<title>공지 사항</title>
</head>

<body id="page-top">

	<%@ include file="../../includes/nav.jsp"%>

	<div id="wrapper">

		<%@ include file="../../includes/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> 게시글
					</div><br>
					<div>
					<form action="updateBoard" method="POST">
					<input type="hidden" name="b_no" id="b_no" value="${board.b_no}">
						<span> 작성 날짜 <input type="text" name=regdate id="regdate" value="${board.regdate}" readonly="readonly"></span>
						<span> 작성자 <input type="text" name="writer" id="writer" value="${board.writer}" readonly="readonly"></span>
					</div><br>
					<div>
						<span> 글제목 <br><input type="text" name="b_title" id="b_title" value="${board.b_title}"></span>
					</div><br>
						글내용 <textarea class="form-control" rows="7" cols="5" name="b_content">${board.b_content}</textarea>
					<div class="card-footer small text-muted">
					<span><input type="submit" id="updateBoard" value="수정"></span>
					</form>
					<span><a href="deleteBoard?b_no=${board.b_no}"><input type="submit" id="deleteBoard" value="삭제"></a></span>
					</div>
				</div>

				<!-- end container-fluid -->

			</div>

			<!-- end content-wrapper -->
		</div>

		<!-- end-wrapper -->
	</div>
</body>
</html>