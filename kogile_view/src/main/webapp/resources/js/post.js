(function($) {
	$(function() {
		$('#reply_modify').hide();
		$('#description_modify').hide();
		$('#description_modify_btn').hide();

		$('#insertPost').on('click', function(){
			var c_no = $('#to-do').attr("data-status");
			$("form[name=insertPost_form]").find('input[name=c_no]').val(c_no);
			insert_post();
			$("input[name=p_title]").val("");
			alert("생성되었습니다.");
		});

		$('.item_content').on('click', function(e){
			var id = $(e.target).closest('a').data('no');
			post_title(id);
		});
		
		$('#deletePost').on('click', function(){
			var id = $('#detail_post_modal').attr('data-id')
			delete_post(id);
		});
		
		$('#modifyPost').on('click', function(){
			var id = $('#detail_post_modal').attr('data-id')
			$(this).attr("href", `post/detailPost/${id}`);
			return true;
		});
		//insert reply
		$('#reply_save').on('click', function(){
			var id = $('#detail_post_modal').attr('data-id');
			var reply= {
					"r_contents":$("#insert_reply").val(),
					"p_no": id,
					"info_no":1
			};
			replyAdd(reply);
//			replyList(id);
			$('#insert_reply').val("");
		});
		// remove reply
		$(document).on("click", ".fas.fa-trash-alt", function(){
			console.log("삭제눌림");
			var r_no = $(this).attr("data-rno");
			console.log(r_no);
			replyRemove(r_no);
//			replyList(id);
			
		});
//		수정 버튼 작동 --> 
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
		
		// modify reply
		$('#reply_modify').on('click', function(){
			
			var reply= {
					"r_contents" : $("#insert_reply").val(),
					"r_no" : $('div .input_box').find('input[name=r_no]').val()
			};
			replyUpdate(reply);
			
			$('#insert_reply').val("");
			
			$('#reply_modify').hide();
			$('#reply_save').show();
		});
//		설명내용 클릭시, 텍스트
		$('#description').on("click",function(){
			var txt = $(this).find('p').html();
			$('#description').find('p').hide();
			$('#description_modify').show();
			$('#description_modify').val(txt);
			$('#description_modify_btn').show();
		});
		//설명수정
		$('#description_modify_btn').on("click", function(){
			var description={"p_description":$('#description_modify').val()}
			updateDescription(description);
		})


	});
//	end window.onload
	//

	// 포스트 삭제
	function delete_post(id) {		
		$.ajax({
			type : "POST",
			url : "/kogile/post/deletePost",
			data : {
				p_no : parseInt(id, 10)
			},
			dataType : "JSON"
		}).then(function(res){
			alert("삭제되었습니다.");
			list_post();
		})
	}

	// 포스트 삽입
	
	function insert_post() {
		const data = $("form[name=insertPost_form]").serialize();
		console.log(data);
		
		$.ajax({
			type : "POST",
			url : "/kogile/post/insertPost",
			data : data,
			dataType : "JSON"
				
		}).then(function(res){
			console.log(res);
		}).then(function(){			
			list_post();
		});
	}

	// 포스트 제목 상세보기
	function post_title(id) {
		
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : `/kogile/post/detail/${id}`
		}).then(function(res){	
			$('#detail_post_modal').attr('data-id', id)
			$('#detail_post_modal').find('.modal-title').text(res.p_title)
		}).then(function(){
			replyList(id);
			showDescription();
		});
	}
	
	function post_description() {
		
		$.ajax({
			type : "GET",
			dataType : "POST",
			url : "/kogile/post/detail/#{p_no}"
		}).then(function(res){
			console.log(res);
			
		});
	}
	
	function list_post(){
		var todo = "";
		var doing ="";
		var done = "";
		var close = "";
		
		$.ajax({
			dataType : "JSON",
			type : "GET",
			url : "/kogile/post/list_post"
		}).then(function(res){
			console.log(res);
			for(var i =0; i < res.length; i ++){
// todo post list 작성
				if(res[i].c_position == 1){
					todo += '<a href="#n" class="detailPostView post ui-state-default" data-status="' + res[i].c_no 
							+ '" data-toggle="modal" data-target="#detail_post_modal">';
					todo += '<div class="post_item">';
					todo += '<input type="hidden" class="select_pno" value="' + res[i].p_no + '">';
					todo += '<h4>' + res[i].p_title + '</h4>';
					todo += '<div class="btn_box">';
					todo += '<span class="list"></span> <span class="check">' + "0/4" + '</span> <span class="date">'+ "Jul 20" +'</span>';
					todo += '</div>';
					todo += '</div></a>';		
				}
// doing
				if(res[i].c_position == 2){
					doing += '<a href="#n" class="detailPostView post ui-state-default" data-status="' + res[i].c_no 
							+ '" data-toggle="modal" data-target="#detail_post_modal">';
					doing += '<div class="post_item">';
					doing += '<input type="hidden" class="select_pno" value="' + res[i].p_no + '">';
					doing += '<h4>' + res[i].p_title + '</h4>';
					doing += '<div class="btn_box">';
					doing += '<span class="list"></span> <span class="check">' + "0/4" + '</span> <span class="date">'+ "Jul 20" +'</span>';
					doing += '</div>';
					doing += '</div></a>';		
				}
// done
				if(res[i].c_position == 3){
					done += '<a href="#n" class="detailPostView post ui-state-default" data-status="' + res[i].c_no 
							+ '" data-toggle="modal" data-target="#detail_post_modal">';
					done += '<div class="post_item">';
					done += '<input type="hidden" class="select_pno" value="' + res[i].p_no + '">';
					done += '<h4>' + res[i].p_title + '</h4>';
					done += '<div class="btn_box">';
					done += '<span class="list"></span> <span class="check">' + "0/4" + '</span> <span class="date">'+ "Jul 20" +'</span>';
					done += '</div>';
					done += '</div></a>';		
				}
// close
				if(res[i].c_position == 4){
					close += '<a href="#n" class="detailPostView post ui-state-default" data-status="' + res[i].c_no 
							+ '" data-toggle="modal" data-target="#detail_post_modal">';
					close += '<div class="post_item">';
					close += '<input type="hidden" class="select_pno" value="' + res[i].p_no + '">';
					close += '<h4>' + res[i].p_title + '</h4>';
					close += '<div class="btn_box">';
					close += '<span class="list"></span> <span class="check">' + "0/4" + '</span> <span class="date">'+ "Jul 20" +'</span>';
					close += '</div>';
					close += '</div></a>';		
				}
			}
			
			$('#to-do').html(todo);
			$('#doing').html(doing);
			$('#done').html(done);
			$('#close').html(close);
			
			
			
		}).catch(function(err){
			console.log(err);
		});
		
		
	}
	//list reply
	function replyList(id) {
		
		$.getJSON("/kogile/reply/"+id)
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
	
	//reply insert
	function replyAdd(reply) {
		
		
		$.ajax({
			type : 'post',
			url : '/kogile/reply/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8"
			}).then(function(res){
				console.log(res);
				reply_list();
				
				
			}).catch(function(e){
				console.log(e);
			})
	}
	
	//remove reply
	function replyRemove(r_no) {
		
		$.ajax({
			type : 'delete',
			url : '/kogile/reply/' + r_no,
			success : function(res) {
				console.log("성공 : ");
				reply_list();
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
//	댓글수정
	function replyUpdate(reply) {
		reply.r_no= $('div .input_box').find('input[name=r_no]').val();
		
		$.ajax({
			type : 'put',
			url : '/kogile/reply/' + reply.r_no,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
		}).then(function(res){
			console.log("성공");
			reply_list();
		}).catch(function(e){
			console.log(e)
		});
	}
//	replylist 파라미터 없이 쓰기위해서 만
	function reply_list(){
		var id = $('#detail_post_modal').attr('data-id');
		replyList(id);
	}
//	설명 보기
	function showDescription() {
		var id = $('#detail_post_modal').attr('data-id');
		$.getJSON("/kogile/post/description/" + id + ".json")
		.then(function(res){
			console.log(res);
			var txt='';
				txt +='<p>';
				txt +=res.p_description;
				txt +='</p>';
				var txt2='';
				txt2 +='<p>';
				txt2 +='포스트설명...';
				txt2 +='</p>';
				
				if(res.p_description==null){
					$('#description').find('div').html(txt2);
				}else{
					$('#description').find('div').html(txt);
				}
			
		}).catch(function(err){
			console.log(err);
		});
		
	}
//	설명수정
	function updateDescription(description) {
		description.p_no = $('#detail_post_modal').attr('data-id');
		console.log(description.p_no);
		$.ajax({
			type : 'put',
			url : '/kogile/post/description/' + description.p_no,
			data : JSON.stringify(description),
			contentType : "application/json; charset=utf-8",
		}).then(function(res) {
				console.log("성공");
				showDescription();
				//버튼과 수정창을 숨겨준다
				$('#description_modify').hide();
				$('#description_modify_btn').hide();
		}).catch(function(e){
			console.log(e);
		});
			
	}
	
})(jQuery);