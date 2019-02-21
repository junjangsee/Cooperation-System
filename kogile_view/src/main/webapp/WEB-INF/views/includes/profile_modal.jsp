<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


	<div class="modal fade" id="profile_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">프로필</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
				
				<div style="float: left; width : 50%">
						<h4>
							<b>이름</b>
						</h4>
						<input type="text" class="form-control" value="<%= user.getName()%>">
						<br>
					
						<h4>
							<b>이메일</b>
						</h4>
						<input type="text" class="form-control" value="<%=user.getEmail() %>" readonly="readonly">
					
					</div>
					
					<div id="profile_picture">
						<p><span class="MYpicture"><%= user.getName().substring(user.getName().length()-2) %></span></p>
						<a href="#">수정</a>
					</div>	
				
				</div>
				<div class="modal-footer">
					<!-- <button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button> -->
					<a class="btn btn-primary" href="*"
					data-dismiss="modal">확인</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>