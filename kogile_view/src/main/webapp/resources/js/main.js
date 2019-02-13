(function ($){
	$(function(){
		project_info();
		list_project();
		list_post();
		
//		설정버튼 클릭 시, 페이지로드없이 설정페이지 --> 서버사이드 
		$('#btn_body_configure').on('click', function(e){
//			$('.card-body').hide();
//			$('#body_configure').show();
			$('.MYactive').removeClass('MYactive');
			$(this).closest('.nav-item').addClass('MYactive');
			
//			console.log($(this).closest('.nav-item'));
//			e.preventDefault();
		});
		
		
	});
//	end window.onload
	
//	프로젝트 정보 불러오기
	function project_info(){
		$.ajax({
			dataType : "JSON",
			url : "/kogile/project/project_info",
			type : "GET"
		}).then(function(res){
			console.log(res);
//			date객체 변환 라이브러리 moment.js
			var date = moment(res.pjt_date).format("YYYY-MM-DD");
//			메인페이지 타이틀
			$('.card-header').find('i').html(" "+ res.pjt_title);
			
//			설정페이지에 프로젝트 정보 삽입
//			$("input[name=pjt_no]").val(res.pjt_no);
//			$('#pjt_title').find('.form-control').val(res.pjt_title);
//			$('#pjt_contents').find('.form-control').val(res.pjt_contents);
//			$('#pjt_date').find('p').html(date);
			
//			마스터 구하기
//			master_info(res.total_m_no);
			
		}).catch(function(err){
			console.log(err);
		});
	}
//	해당프로젝트 카드 넘버 조회 및 data-status값에 대입
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
	
//	function master_info(total_m_no){
//		const data = {
//				total_m_no : total_m_no
//		}
//		var name = "";
//		var resn = "";
//		
//		$.ajax({
//			data : data,
//			dataType : "JSON",
//			type : "POST",
//			url : "/kogile/project/master_info"
//		}).then(function(res){
//			console.log(res);
////			글자 자르기
//			resn = res.name;
//			name = resn.substring(resn.length -2);
////			설정 페이지에 마스터 정보 넣기 
////			$('#master_info').find('.name').html(name);
////			$('#master_info').find('p').html(resn);
////			$('#master_info').find('a').html(res.mail);
//		}).catch(function(err){
//			console.log(err);
//			
//		});
//	}
	
})(jQuery)




