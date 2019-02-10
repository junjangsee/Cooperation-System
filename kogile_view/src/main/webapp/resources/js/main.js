(function ($){
	$(function(){
		list_project();
		list_post();
	});
	
	
	function list_project(){
		$.ajax({
			dataType : "JSON",
			url : "/kogile/post/list_card",
			type : "GET"
		}).then(function(res){
			console.log(res);
			$('#to-do').attr("data-status", res[0].c_no);
			$('#doing').attr("data-status", res[1].c_no);
			$('#done').attr("data-status", res[2].c_no);
			$('#close').attr("data-status", res[3].c_no);
			
		}).catch(function(err){
			console.log(err);
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
	}
	
	
})(jQuery)