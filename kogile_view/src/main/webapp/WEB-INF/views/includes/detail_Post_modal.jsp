<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link href="/resources/css/post.css" rel="stylesheet"> -->
<title>Insert title here</title>

<%-- <%@include file="../includes/ex.jsp" %> --%>
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
					<input class="form-control" id="updateTitle"
						placeholder="제목을 입력하세요" />
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
					
						<span aria-hidden="true" class="exit_modal">×</span>

					</button>
				</div>
				<div id="modalBody" class="modal-body">
					<div class="MYhide_menu"></div>
					<!-- end myhide_menu -->

					<div class="right_list" style="width: 30%; height: 100%; margin-left: 45px;">
						<div class="addcard_holder holder">
							<h2 class="title_c"><b>마감일</b></h2>
							<div id="end_date"></div><br>
							<h2 class="title_c"><b>라벨</b></h2>
							<ul class="label_list" style="padding-left: 2px;">
							</ul>							
							<br>
							<h2 class="title_c"><b>첨부파일</b></h2>
							<br>
							<!-- <div class="btn_list" >
								<a href="#" class="mem_btn">Members</a> <a href="#"
									class="label_btn">Labels</a> <a href="#" class="check_btn">Checklist</a>
								<a href="#" class="due_btn">Due Date</a> <a href="#"
									class="atta_btn">Attachment</a>

							</div> -->
						</div>
					</div>
					<!-- right_list end -->
					<div style="width : 70%;">
					<input type="hidden" value="" id="MYpno">

					<!-- 설명 -->
					<div id="description">
						<h4>
							<b>설명</b>
						</h4>
						<div id="clickDes">
							<!-- P 태그들어간다. -->
						</div>
						<textarea id="description_modify" class="add_input"
							placeholder="포스트설명..."></textarea>
						<a id="description_modify_btn" href="#n"
							class="btn btn-sm btn-secondary" style="float: right;">수정</a>
					</div>
					<!-- end 설명 -->

					<br>
					<div id="reply_comment">
						<h4>
							<b>댓글달기</b>
						</h4>
						<span class="name" style="margin-right: 3px;">user</span>
						<textarea id="insert_reply" style="margin-bottom: 3px;"
							class="add_input" placeholder="Write a comment..."></textarea>

						<input type="text" class="add_tag" placeholder="ex)회원1" id = autoComplete value="">
						<input type="hidden" id="tag_info_no" value=""/>
						<input type="hidden" id="tag_total_m_no" value=""/>
						<input type="hidden" id="tag_name" value=""/>
						<a id="reply_save" href="#n" class="btn btn-sm btn-secondary"
							style="float: left; position: relative; left: 70%;">등록</a> <a id="reply_modify" href="#n"
							class="btn btn-sm btn-secondary" style="float: left;left: 70%;position: relative;">수정</a>
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
					
					<!-- 체크리스트 시작 -->
					<div>
					<h4><b>체크리스트</b></h4>
					<div id="list_Checklist">
					</div>
					
					<!-- <div class="progress" style="width : 70%;">
					<div class="progress-bar" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
					</div> -->
					</div>
					<!-- 체크리스트 종료 -->
					</div>
					<!-- leftmenu end -->
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