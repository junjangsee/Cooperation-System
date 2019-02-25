(function($) {
	$(function() {
//		사이드바 선택한 메뉴 활성화
		$('.MYactive').removeClass('MYactive');
		$('.fa-tachometer-alt').closest('.nav-item').addClass('MYactive');
		
		$('#modify_pjt').on('click',function(e) {
			e.preventDefault();
			$("form[name=project_info]").attr("action", "/kogile/project/modify");
			$("form[name=project_info]").submit();
		});

		$('#delete_pjt').on('click',function(e) {
			e.preventDefault();
			$.ajax({
				type : "GET",
				dataType : "text",
				url : "/kogile/project/delete",
			}).then(function(res){
				console.log(res);
				window.location.href="http://localhost:8082/kogile/startPage";
			}).catch(function(e){
				if(e.status == 400){
					swal("프로젝트 알림", e.responseText);
				}
			})
			
//			$("form[name=project_info]").attr("action", "/kogile/project/delete");
//			$("form[name=project_info]").submit();
		});
		
		
	})
})(jQuery)