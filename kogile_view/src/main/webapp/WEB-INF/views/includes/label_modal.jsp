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


	<div class="modal fade" id="label_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">모달 제목</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="label_info">
					<input type="hidden" name="label_no" val="">
					<h4><b>라벨 명</b></h4>
					<input type="text" class="form-control" name="label_text" style="width: 60%;" value="" placeholder="라벨 이름"><br>
					
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="1" checked>
								<div class="label_radio labelcolor_red"></div>
							</label>
						</div>
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="2">
								<div class="label_radio labelcolor_orange"></div>
							</label>
						</div>
						<div class="radio-inline">
							<label> <input type="radio" name="color_no"
								value="3">
								<div class="label_radio labelcolor_yellow"></div>
							</label>
						</div>
						<div class="radio-inline">
							<label> 
							<input type="radio" name="color_no" value="4">
							<div class="label_radio labelcolor_green"></div>
							</label>
						</div>
					
					
					</form>
				
				</div>
				<div class="modal-footer">
					<div class="insertLabel">
					<a id="insertLabel" class="btn btn-primary" href="#"
					data-dismiss="modal">등록</a>
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					</div>
					<div style="display: none;" class="updateLabel">
					<button class="btn btn-warning" type="button" id="updateLabel"
						data-dismiss="modal">수정</button>
					<button class="btn btn-danger" type="button" id="deleteLabel"
						data-dismiss="modal">삭제</button>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>