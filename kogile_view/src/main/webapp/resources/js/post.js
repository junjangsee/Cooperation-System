(function($) {
	$(function() {

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
//				todo post list 작성
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
//				doing
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
//				done
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
//				close
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
		
		function updateDescription(description) {

			$.ajax({
				type : 'put',
				url : '/kogile/post/description/' + description.p_no,
				data : JSON.stringify(description),
				contentType : "application/json; charset=utf-8",
				success : function(res) {
					console.log("성공");
				},
				error : function(xhr, status, er) {
					if (error) {
						error(er);
					}
				}
			});
		}

		function showDescription(p_no) {
			
			$.getJSON("/kogile/post/description/" + p_no + ".json")
			.then(function(res){
				console.log(res);
				var txt='';
					txt +='<li>';
					txt +=res.p_description
					txt +='</li>'
				$('#ex2').html(txt);
			}).catch(function(err){
				console.log(err);
			});
			
		}
	}
	
	
})(jQuery);