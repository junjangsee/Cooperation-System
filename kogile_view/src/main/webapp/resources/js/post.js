(function($) {
	$('#reply_modify').hide();
	$('#description_modify').hide();
	$('#description_modify_btn').hide();
	list_post();
	
//	$('#insertPost').on('click', function(){
//		var c_no = $('#to-do').attr("data-status");
//		$("form[name=insertPost_form]").find('input[name=c_no]').val(c_no);
//		insert_post();
//		$("input[name=p_title]").val("");
//		alert("생성되었습니다.");
//	});
//	// Post 제목 상세보기
//	$('.item_content').on('click', function(e){
//		var id = $(e.target).closest('a').data('no');
//		post_title(id);
//	});
//	
//	
//	$('#deletePost').on('click', function(){
//		var id = $('#detail_post_modal').attr('data-id')
//		delete_post(id);
//	});
//	

	$('#modifyPost').on('click', function(){
		var id = $('#detail_post_modal').attr('data-id');
		$(this).attr("href", `post/detailPost/${id}`);
		return true;
	});
	
	//insert reply
	$('#reply_save').on('click', function(){
		var id = $('#detail_post_modal').attr('data-id');
		var reply= {
				"r_contents":$("#insert_reply").val(),
				"p_no": id
		};
		replyAdd(reply);
//		replyList(id);
		$('#insert_reply').val("");
	});
	
	// remove reply
	$(document).on("click", ".fas.fa-trash-alt", function(){
		console.log("삭제눌림");
		var r_no = $(this).attr("data-rno");
		console.log(r_no);
		replyRemove(r_no);
//		replyList(id);
		
	});
//	수정 버튼 작동 --> 
	
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
	
//	설명내용 클릭시, 텍스트
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

	
	// ------------------------------------------------ Start Post 삽입
	
	// Post 삽입
	$('#insertPost').on('click', function(){
		var c_no = $('#to-do').attr("data-status");
		$("form[name=insertPost_form]").find('input[name=c_no]').val(c_no);
		insert_post();
		$("input[name=p_title]").val("");
		alert("생성되었습니다.");
	});
//	end window.onload
	//

//	 Post 제목 상세보기
	$('.item_content').on('click', function(e){
		var id = $(e.target).closest('a').data('no');
		post_title(id);
	});

	
	// Post 삭제
	$('#deletePost').on('click', function(){
		var id = $('#detail_post_modal').attr('data-id');
		delete_post(id);
	});
	
	// Post 제목 수정 
	// p_title : 현재 제목 updateTitle : 수정 제목
	$('#p_title').on('click', function(e){
		showUpdateInput();
		$('#updateTitle').val($('#p_title').text())
		isUpdate = true;
	})
	
	
	$('#updateTitle').on('focusout', function(e) {	
		update_p_title($(this).val())
		isUpdate = false;
	})
	
	$('#updateTitle').on('keyup', function(e) {
		if (e.keyCode === 13) {
			update_p_title($(this).val())
			isUpdate = false;
		}
	})
	
	
	// 포스트 제목 수정
	function update_p_title(title) {
		if(isUpdate){
			$.ajax({
				type : "PATCH",
				url : "/kogile/post/updatePostTitle",
				data : JSON.stringify({
					p_title: title
				}),
				contentType : "application/json; charset=UTF-8"
			}).then(function(res){
				alert('저장되었습니다.');
				$('#p_title').text(title);
				showTitle();
			}).catch(function(err){
				showTitle();
				console.error(err)
			})
		}
	}

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
	
	// ------------------------------------------------ End Post 삽입
	

	// 포스트 상세보기
	// ------------------------------------------------ Start Post 제목 상세보기
	
	// Post 제목 상세보기
	$('.item_content').on('click', function(e){
		var id = $(e.target).closest('a').data('no');
		post_title(id);
	});
	
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
			writer_info();

		});
	}
	
	// ------------------------------------------------ End Post 제목 상세보기
	
	// ------------------------------------------------------------- start Post 제목 삭제
	
	$('#deletePost').on('click', function(){
		var id = $('#detail_post_modal').attr('data-id');
		delete_post(id);
	});
	
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
	
	// ------------------------------------------------------------- End Post 제목 삭제
	
	// ------------------------------------------------------------- start Post 제목 수정 
	// p_title : 현재 제목 updateTitle : 수정 제목
	
	//title 수정
	var isUpdate = false
	
	function showTitle() {
		$('#updateTitle').hide();
		$('#p_title').show();
	}
	
	function showUpdateInput() {
		$('#updateTitle').show();
		$('#p_title').hide();
	}
	
	$('#p_title').on('click', function(){
		showUpdateInput();
		$('#updateTitle').val($('#p_title').text())
		isUpdate = true;
	})
	
	
	$('#updateTitle').on('focusout', function() {	
		var id = $('#detail_post_modal').attr('data-id');
		update_p_title($(this).val(), id)
		isUpdate = false;
	})
	
	$('#updateTitle').on('keyup', function(e) {
		var id = $('#detail_post_modal').attr('data-id');
		if (e.keyCode === 13) {
			update_p_title($(this).val(), id)
			isUpdate = false;
		}
	})
	
	// 포스트 제목 수정
	function update_p_title(title, id) {
		
		if(isUpdate){
			$.ajax({
				type : "PATCH",
				url : "/kogile/post/updatePostTitle",
				data : JSON.stringify({
					p_title : title,
					p_no : parseInt(id, 10)
				}),
				contentType : "application/json; charset=UTF-8"
			}).then(function(res){
				alert('저장되었습니다.');
				$('#p_title').text(title);
				showTitle();
			}).catch(function(err){
				showTitle();
				console.error(err)
			})
		}
	}
	
	// ------------------------------------------------------------- end post 제목 수정
	

	function post_description() {
		
		$.ajax({
			type : "GET",
			dataType : "POST",
			url : "/kogile/post/detail/#{p_no}"
		}).then(function(res){
			console.log(res);
			
		});
	}
	
	//	해당 프로젝트 포스트 조회 후, c_no에 맞게 삽입
//	해당 프로젝트 포스트 조회 후, c_no에 맞게 삽입
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
//				todo post list 작성
				if(res[i].c_position == 1){
					todo += renderComponent(res[i])
				}
//				doing
				if(res[i].c_position == 2){
					doing += renderComponent(res[i])
				}
//				done
				if(res[i].c_position == 3){
					done += renderComponent(res[i])		
				}
//				close
				if(res[i].c_position == 4){
					close += renderComponent(res[i])	
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
	
	// 리스트 뿌려주기 (템플릿 리터럴을 통해서)
	function renderComponent(list) {
		
		return `
		<a href="#n" class="detailPostView post ui-state-default" data-status="${list.c_no}" data-toggle="modal"
		 data-target="#detail_post_modal" data-no="${list.p_no}">
			<div class="post_item">
				<h4>${list.p_title}</h4>
				<div class="btn_box"> 
					<span class="list"></span> 
					<span class="check"> 0/4 </span> 
					<span class="date">${list.p_dday ? list.p_dday : '마감일이 없습니다.'}</span>
				</div>
				<span id="listDday" class="tag ${list.p_dday ? 'show' : 'hide'}">
					${getDday(list.p_dday)}
				</span>
			</div>
		</a>
		`
	}
	
	// --------------------------------------------------------- start Dday 계산
	
	// 디데이 계산
	function getDday(date) {		
		var dday = Math.floor((new Date(date).getTime() - new Date()) / (1000 * 60 * 60 * 24));
		
		if (dday === -1) {
			return 'D-day'
		};
		
		return dday > 0 ? `D-${dday}` : `D+${dday + 1}`
	}
	
	// --------------------------------------------------------- End Dday 계산

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
	
	function writer_info(){
		
		var name = "";
		var resn = "";
		
		$.ajax({
			dataType : "JSON",
			type : "GET",
			url : "/kogile/project/master_info"
		}).then(function(res){
			console.log(res);
//			글자 자르기
			resn = res.name;
			name = resn.substring(resn.length -2);
//			설정 페이지에 마스터 정보 넣기 
//			$('#master_info').find('.name').html(name);
			$('#reply_comment').find('.name').html(name);
			$('#reply_list').find('.name').html(name);
//			$('#master_info').find('p').html(resn);
//			$('#master_info').find('a').html(res.mail);
		}).catch(function(err){
			console.log(err);
			
		});
	}
	
	
	
})(jQuery);