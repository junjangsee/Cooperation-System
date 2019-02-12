<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<h3 class="modal-title" id="exampleModalLabel">post_name 상세보기</h3>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
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

					<!-- 설명 -->
					<div id="description">
						<h4>
							<b>설명</b>
						</h4>
						<div>
							<p>포스트 설명...</p>
						</div>
					</div>

					<br>

					<!-- 체크리스트 출력하기 1개 ?   -->
					<!-- 				<div id="checklist">
				 <b><textarea class="add_inputck" placeholder="test Checklist..."></textarea></b>
				</div> -->
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>#checklist_no</th>
								<th>check_title</th>
								<th>p_no</th>
							</tr>
						</thead>

						<c:forEach items="list" var="ck">
							<tr>
<%-- 								<td><c:out value="${ck.checklist_no }"/></td>
								<td><c:out value="${ck.check_title }"/></td>
								<td><c:out value="${ck.p_no }"/></td> --%>
							</tr>
						</c:forEach>
					</table>


					<div id="reply_comment">
						<h4>
							<b>댓글달기</b>
						</h4>
						<span class="name">user</span>
						<textarea class="add_input" placeholder="Write a comment..."></textarea>

					</div>
					<!-- end reply_comment -->

				</div>
				<!-- end modal-body -->
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-warning">수정</a> <a class="btn btn-primary"
						href="#" data-dismiss="modal">등록</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>