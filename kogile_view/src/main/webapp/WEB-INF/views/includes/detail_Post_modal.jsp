<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/css/post.css" rel="stylesheet">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</head>
<body>
	<!-- Butto 사용  -->
	<!-- <button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">Launch demo modal
	</button> -->


	<div class="modal fade" id="detail_post_modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="p_title">Post 제목</h3>
					<input class="form-control" id="updateTitle" placeholder="제목을 입력하세요" />
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
					
						<span aria-hidden="true" class="exit_modal">×</span>
					</button>
				</div>
				<div id="modalBody" class="modal-body">
					<div class="MYhide_menu"></div>
					<!-- end myhide_menu -->

					<div class="right_list">
						<div class="addcard_holder holder">
							<h3 class="title_c">ADD TO CARD</h3>
							<div class="btn_list">
								<a href="#" class="mem_btn">Members</a> <a href="#"
									class="label_btn">Labels</a> <a href="#" class="check_btn">Checklist</a>
								<a href="#" class="due_btn">Due Date</a> <a href="#"
									class="atta_btn">Attachment</a>
							</div>
						</div>
				</div>
				<!-- right_list end -->		
				
				<input type="hidden" value="" id="MYpno">
				
				<!-- 설명 -->
				<div id="description">
				<h4><b>설명</b></h4>
					<div>
						<!-- P 태그들어간다. -->
					</div>
					<textarea id="description_modify" class="add_input" placeholder="포스트설명..."></textarea>
					<a id="description_modify_btn" href="#n" class="btn btn-sm btn-secondary" style="float : right;">수정</a>				
				</div>
				<!-- end 설명 -->
				
				<br>
				<div id="reply_comment">
				<h4><b>댓글달기</b></h4>
				<span class="name">user</span>
				<textarea id="insert_reply" style="margin-bottom: 3px;" class="add_input" placeholder="Write a comment..."></textarea>
				<input type="text" class="add_tag" placeholder="@태그">
				<a id="reply_save" href="#n" class="btn btn-sm btn-secondary" style="float : right;">등록</a>
				<a id="reply_modify" href="#n" class="btn btn-sm btn-secondary" style="float : right;">수정</a>
				</div>
				<!-- end reply_comment -->
				
				<!-- 댓글목록 -->
				<ul id="reply_list" style="list-style: none; padding-left: 0px;">
					<!-- <li id="reply_list"> -->
					<!-- <span class="name">철희</span>
						<div class="input_box">
							<span class="fullname">정철희</span><br>
							 <span class="date">Jan
								16 at 10:00 AM</span> 
								<span class="cts"> 
								<span class="id">@junjang7</span>
								ㅎㅇㅎㅇ
								</span>  -->
							<!-- <a href="#n" class="rep_btn">Reply</a> -->
						<!-- </div> -->
					<!-- </li> -->
				</ul>
				<!-- 댓글목록 종료 -->


				</div>
				<!-- end modal-body -->
				
				<!-- <div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-warning">수정</a>
					<a class="btn btn-primary" href="#" data-dismiss="modal">등록</a> -->

				<div class="modal-footer">
					<button id="deletePost" class="btn btn-danger" type="button"
						data-dismiss="modal">삭제</button>
					<a href="#" class="btn btn-warning" id="modifyPost">상세 보기</a> 

					
				</div>
			</div>
		</div>
	</div>
	
	<!-- 해당내용 P_no 조회를 한후 가능할 예정 P404 , 우선 임의의 P-no 값 입력으로 테스트-->
	<%-- <c:out value="${p_no }"></c:out> --%>
	

	

</body>

</html>