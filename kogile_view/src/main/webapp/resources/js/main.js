(function ($){
	
		$('.fa-folder').closest('.nav-item').addClass('MYactive');
		
		project_info();
		list_project();
		
////		설정버튼 클릭 시, 페이지로드로 바꾸면서 주석으로 변경
//		$('#btn_body_configure').on('click', function(e){
////			$('.card-body').hide();
////			$('#body_configure').show();
//			$('.MYactive').removeClass('MYactive');
//			$(this).closest('.nav-item').addClass('MYactive');
//			
////			console.log($(this).closest('.nav-item'));
////			e.preventDefault();
//		});
		
//		$('#modify_pjt').on('click', function(){
//			$("form[name=project_info]").attr("action", "/kogile/project/modify");
//			$("form[name=project_info]").submit();
//		})
//		
//		$('#delete_pjt').on('click', function(){
//			$("form[name=project_info]").attr("action", "/kogile/project/delete");
//			$("form[name=project_info]").submit();
//		})

		
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
//			$('#master_info').find('.name').html(name);
//			$('#reply_comment').find('.name').html(name);
//			$('#reply_list').find('.name').html(name);
//			$('#master_info').find('p').html(resn);
//			$('#master_info').find('a').html(res.mail);
//		}).catch(function(err){
//			console.log(err);
//			
//		});
//	}
	
	
})(jQuery)




