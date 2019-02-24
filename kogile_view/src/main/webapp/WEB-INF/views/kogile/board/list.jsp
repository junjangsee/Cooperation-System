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

<title>공지 사항</title>
</head>

<body id="page-top">

	<input id="rw" type="hidden" value="><%= session.getAttribute("total_m_no") %>" name="total_m_no">

	<%@ include file="../../includes/nav.jsp"%>
	<div id="wrapper">

		<%@ include file="../../includes/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> 공지 사항
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th style="width: 9%">글번호</th>
										<th style="width: 50%">글제목</th>
										<th style="width: 9%">작성자</th>
										<th style="width: 10%">작성일</th>
										<th style="width: 10%">수정일</th>
									</tr>
								</thead>

								<c:forEach items="${list}" var="board">
									<tr>
										<td><c:out value="${board.b_no}"></c:out></td>
										<td><a href="detailBoard?b_no=${board.b_no}">${board.b_title}</a></td>
										<td><c:out value="${board.writer}"></c:out></td>
										<td><fmt:formatDate value="${board.regdate}"
												pattern="yyyy-MM-dd" /></td>
										<td><fmt:formatDate value="${board.update_date}"
												pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<a href="insertBoardForm"><input type="button" value="글쓰기"></a>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
					<!-- end container-fluid -->
				</div>
				<!-- end content-wrapper -->
			</div>
			<!-- end-wrapper -->
		</div>
		<%@ include file="../../includes/footconfig.jsp"%>
		<script src="/resources/js/board2.js"></script>
		<!-- <script src="/resources/js/board.js"></script> -->
</body>
</html>