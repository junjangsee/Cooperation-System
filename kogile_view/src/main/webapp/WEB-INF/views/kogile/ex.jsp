<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/dragula/3.7.2/dragula.min.js"></script>
<script type="text/javascript"src="/resources/js/reply.js"></script>
<script type="text/javascript"src="/resources/js/post.js"></script>
<script>
$(document).ready(function(){
	showList(1);
	showDescription(1);
	function showList(p_no){
		replyService.showList(p_no);
	}
	function showDescription(p_no){
		postService.showDescription(p_no);
	}
	$('#a').click(function(){
		replyService.add({r_contents:"아작테스트",p_no:"1",info_no:"1"})
	})
	$('#b').click(function(){
		replyService.update({r_contents:"수정된아작테스트",r_no:"101"})
	})
	$('#c').click(function(){
		replyService.remove(101)
	})
	$('#d').click(function(){
		postService.updateDescription({p_description:"아작테스트!!!",p_no:"1"})
	})
})

</script>
</head>
<body>
<h1>앙</h1>
<p>머야머야</p>
	<div id="ex">
	
	</div>
	<br>
	<br>
	<div id="ex2">
	
	</div>
	<br>
	<br>
	<br>
	<button id="a">댓글등록</button>
	<button id="b">댓글수정</button>
	<button id="c">댓글삭제</button>
	<button id="d">설명수정</button>
</body>
</html>