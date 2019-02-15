console.log("replyModule...................");

var replyService = (function() {
	
	
	$(function() {
		//p_no를 가져와서 댓글 목록을 보여준다. 이때 수정창은 숨겨져 있다.
		$(document).on("click", ".detailPostView.post.ui-state-default", function(){
			var p_no = $(this).find(".select_pno").val();
			console.log(p_no);
			$('#detail_post_modal').find('input[name=p_no]').val(p_no);
			
			replyService.showList();
			$('#reply_modify').hide();
		});
		
		//등록 버튼을 누르면 글이 등록된다.
		$('#reply_save').on('click', function(){
			
			var reply= {
					"r_contents":$("#insert_reply").val(),
					"p_no":$("input[name=p_no]").val(),
					"info_no":1
			};
			replyService.add(reply);
			
			$('#insert_reply').val("");


		});
		//수정버튼을 누르면 글이 수정되고 수정버튼이 닫아지고 다시 등록버튼이 보인다
		$('#reply_modify').on('click', function(){
			
			var reply= {
					"r_contents":$("#insert_reply").val()
			};
			replyService.update(reply);
			
			$('#insert_reply').val("");
			
			$('#reply_modify').hide();
			$('#reply_save').show();
		});
		//삭제아이콘을 누르면 삭제를한다
		$(document).on("click", ".fas.fa-trash-alt", function(){
			console.log("삭제눌림");
			var r_no = $(this).attr("data-rno");
			console.log(r_no);
			replyService.remove(r_no);
		});
		//수정아이콘을 누르면 댓글 내용을 수정창에 집어넣고 등록버튼을 숨긴 후 수정버튼을 보이게 한다.
		$(document).on("click", ".fas.fa-edit", function(){
			console.log("수정눌림");
			var r_no = $(this).attr("data-rno");
			console.log(r_no);
			var txt = $(this).parents('div .input_box').find('.cts').html();
			console.log(txt);
			var reply= {
					"r_contents":$("#insert_reply").val()
			};
			
			$('#insert_reply').val(txt);
			$('#reply_save').hide();
			$('#reply_modify').show();
		});
		
		
		
		
	});
//console.log("test");
	function add(reply) {
		console.log("add reply...............");

		$.ajax({
			type : 'post',
			url : '/kogile/reply/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				console.log(res);
				replyService.showList();
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
					console.log('error');
				}
			}
		})
	}
	
	function remove(r_no) {
		
		$.ajax({
			type : 'delete',
			url : '/kogile/reply/' + r_no,
			success : function(res) {
				console.log("성공 : ");
				replyService.showList();
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function update(reply) {
		console.log("update reply...............");
		reply.r_no= $('div .input_box').find('input[name=r_no]').val();
		
		$.ajax({
			type : 'put',
			url : '/kogile/reply/' + reply.r_no,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				console.log("성공");
				replyService.showList();
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function showList() {
		var p_no = $('#detail_post_modal').attr('data-id');
		
		$.getJSON("/kogile/reply/"+p_no)
		.then(function(res){
			console.log(res);
			var txt='';
			
			for(var i =0;i<res.length;i++){
				txt +='<li>';
				txt +='<span class="name">'+res[i].name.substring(res[i].name.length-2) +'</span>';
				txt +='<div class="input_box">'
				txt +='<span class="fullname">'+res[i].name+'</span><br>'
				txt +='<span class="date">'+ moment(res[i].r_date).format("YYYY-MM-DD")+'</span>'
				txt +='<a class="fas fa-edit" data-rno="'+res[i].r_no + '"href="#"/><a class="fas fa-trash-alt" data-rno="'+res[i].r_no + '" href="#"/>'
				txt +='<input type="hidden" name="r_no" value="'+res[i].r_no+'"/>'
				txt +='<span class="cts">'+res[i].r_contents+'</span>'
				txt += '</div>';
				txt += '</li>';
			}
			$('#reply_list').html(txt);

			
		}).catch(function(err){
			console.log(err);
		});
		
	}

	return {
		add : add,
		showList : showList,
		remove : remove,
		update : update
	};

})();
