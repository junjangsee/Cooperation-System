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
<link href="/resources/css/main.css" rel="stylesheet">

<title>project_name</title>
</head>
<body id="page-top" >
	<!-- modal -->
	<%@ include file="../includes/format_modal.jsp" %>
	<%@ include file="../includes/detail_Post_modal.jsp" %>
	<%@ include file="../includes/insert_Post_modal.jsp" %>
	<!-- end modal -->
	
	<!-- nav -->
	<%@ include file="../includes/nav.jsp"%>

	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="../includes/sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table">   pjt_name</i>
						
					</div>
					<div class="card-body">
					
				
						
						<div class="cts_board grid">
						
							<div class="item">
								<div class="heading">
									<h3 class="board_title">todo</h3>
									<a href="#n" class="more">···</a>
								</div>
								
								<div class="item_content" id="to-do" data-status="1">
										<a href="#n" class="detailPostView post ui-state-default" data-status="1">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="1">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
										
										<!-- example modal -->
										<a href="#n" class="detailPostView post ui-state-default" data-status="1"
										data-toggle="modal" data-target="#detail_post_modal">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="2">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> 
												<span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
										
										<a href="#n" class="detailPostView post ui-state-default" data-status="1">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="3">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
										
								</div>
								<button class="add_txt" data-toggle="modal" data-target="#insert_Post_modal">post 생성</button>
							</div>
							
							<div class="item">
								<div class="heading">
									<h3 class="board_title">doing</h3>
									<a href="#n" class="more">···</a>
								</div>
								<div class="item_content" id="doing" data-status="2">
										<a href="#n" class="detailPostView post ui-state-default" data-status="2">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="1">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
								</div>
								
								
							</div>
							
							<div class="item">
								<div class="heading">
									<h3 class="board_title">done</h3>
									<a href="#n" class="more">···</a>
								</div>
								<div class="item_content" id="done" data-status="3">
										<a href="#n" class="detailPostView post ui-state-default" data-status="3">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="1">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
										
										<a href="#n" class="detailPostView post ui-state-default" data-status="3">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="1">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
								</div>
							</div>
							
							<div class="item">
								<div class="heading">
									<h3 class="board_title">close</h3>
									<a href="#n" class="more">···</a>
								</div>
								<div class="item_content" id="close" data-status="4">
										<a href="#n" class="detailPostView post ui-state-default" data-status="4">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="1">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> <span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
										</a>
								</div>
							</div>
							
						</div>
						<!-- cts board grid -->
					</div>
					<!-- end cardbody -->
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

<%-- 			<div class="cts_board grid">


				<c:forEach var="card" items="${card}">

					<div class="item">
						<div class="heading">
							<h3 class="board_title">${card.c_title}</h3>
							<a href="#n" class="more">···</a>
						</div>

						<div class="item_content" id="${card.c_position}" data-status="${card.c_no }">

						<div id="${card.c_no}">
							<c:forEach var="post" items="${post}">
								<c:if test="${card.c_no == post.c_no}" >
									<a href="#n" class="detailPostView post ui-state-default" data-status="${card.c_no }">
										<div class="post_item">
											<input type="hidden" class="select_pno" value="11">
								
											<h4>post_title</h4>
											<div class="btn_box">
												<span class="list"></span> 
												<span class="check">0/4</span> 
												<span class="date">Jul 20</span>
											</div>
											<div class="peo_box"></div>
										</div>
									</a>
								</c:if>
							</c:forEach>
						</div>

						</div>

						<button class="add_txt"
							href="insertPostFormAction.post?pjt_no=${project.pjt_no}">post
							생성</button>
					</div>
				</c:forEach>
			</div> --%>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<%@ include file="../includes/content_footer.jsp"%>


		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->



	<%@ include file="../includes/footconfig.jsp"%>

</body>
</html>