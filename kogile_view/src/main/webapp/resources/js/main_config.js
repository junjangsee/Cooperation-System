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
			console.log("test");
			e.preventDefault();
			$("form[name=project_info]").attr("action", "/kogile/project/delete");
			$("form[name=project_info]").submit();
		});
		
		
	})
})(jQuery)