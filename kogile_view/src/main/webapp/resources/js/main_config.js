(function($) {
	$(function() {
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