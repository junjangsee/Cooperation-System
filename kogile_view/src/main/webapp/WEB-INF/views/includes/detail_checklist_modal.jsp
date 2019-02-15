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


	<div class="modal fade" id="detail_checklist_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">체크리스트 추가</h3>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					
					<h4><b>제목</b></h4>
					<input type="text" class="form-control" name="check_title">
					
				
				</div>
				<!-- end modal-body -->
				<div class="modal-footer">
					<a id="insertCheck" class="btn btn-primary" href="#" data-dismiss="modal">등록</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>