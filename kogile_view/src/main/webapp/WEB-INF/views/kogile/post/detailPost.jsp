
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("n", "\n"); %>
<% pageContext.setAttribute("br", "<br/>"); %>
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
<link href="/resources/css/post.css" rel="stylesheet">

<!-- Date CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<link rel="stylesheet" type="text/css"
	href="https://npmcdn.com/flatpickr/dist/themes/dark.css">

<!-- Date PlugIn -->

<title>포스트 상세보기</title>
</head>
<body id="page-top">
	<!-- include zone -->
	<%@ include file="../../includes/label_modal.jsp" %>
	<%@ include file="../../includes/detail_checklist_modal.jsp" %> 

	<!-- end indclude zone -->


	<%@ include file="../../includes/nav.jsp"%>

	<div id="wrapper">

		<c:set var="pjt_no"><%=(int) session.getAttribute("pjt_no")%></c:set>
		<!-- Sidebar -->
		<%@ include file="../../includes/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> <span id="title_header">포스트 상세정보</span>
					</div>

					<div class="card-body">

						<div class="right_list">
							<div class="addcard_holder holder">
								<h3 class="title_c">ADD TO CARD</h3>
								<div class="btn_list">
									<!-- <a href="#" class="mem_btn">Members</a> --> 
									<a id="MY_btn_label"
										href="#" class="label_btn" role="button" data-toggle="popover"
										data-trigger="focus" title="Label" data-content="">Labels</a>
									<a id="MY_btn_check" href="#" class="check_btn"
										data-toggle="modal" data-target="#detail_checklist_modal">Checklist</a>
									<a href="#" class="due_btn" id="MY_btn_due">Due Date</a> 
									<!-- <a href="#" class="atta_btn">Attachment</a> -->
								</div>
							</div>
						</div>

						<form name="post_info">
							<input type="hidden" value="${post.p_no}" id="p_no" name="p_no">

							<div style="width: 30%; float: left; margin-right: 10px;">
								<h4>
									<b>포스트 명</b>
								</h4>
								<input id="title" class="form-control" value="${post.p_title}" placeholder="제목을 입력하세요"><br>
							</div>

							<c:set var="d_day">
								<fmt:formatDate value="${post.p_dday}" pattern="yy-MM-dd" />
							</c:set>

							<h4>
								<b>마감일</b> <span id="delete_date" style="font-size: x-small;" >삭제하기</span>
							</h4>
							<input id="due_date" class="form-control" style="width: 30%" 
								value="${post.p_dday}" placeholder="ex)2019-02-26"><br>
								
							<div>
							<h4><b>설명</b></h4>
							<c:set value="${fn:replace(post.p_description, br, n)}" var="des" />
							<textarea id="detail_description" name="description" style="width: 65%;" class="add_input" placeholder="설명을 입력하세요">${fn:replace(des, br, n)}</textarea><br>

							</div>

							<h4>
								<b>담당자</b>
							</h4>
							<br> <br>

							<h4>
								<b>라벨</b>
							</h4>
							<ul id="label_info_list" class="label_list2">
							</ul>
							<br>
							<br>
							

							<h4><b>체크리스트</b></h4>
							<div id="list_Checklist" style="width :70%;"></div>
							<br> <br>

						</form>
						<!-- <a class="btn btn-primary" href="#">수정</a> --> 
						<a class="btn btn-primary" href="/kogile/main?pjt_no=${pjt_no}">완료</a>
					</div>
					<!-- end card-body -->
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>
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
	<script src="/resources/js/post.js"></script>
	<script src="/resources/js/checklist.js"></script>


</body>
</html>