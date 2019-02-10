(function ($){
	$(function(){
		
		list_project();
	});
	
	
	function list_project(){
		$.ajax({
			dataType : "JSON",
			url : "/kogile/project/list_card",
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
	
	
	
})(jQuery)