(function ($){
	$(function(){
		list();
		
		$('#insert_project').on('click', function(){
			insert_project();
			list();
		});
	});
	
	function list(){
		var txt = "";
		
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : "/kogile/project/list",
		}).then(function(res){
			console.log(res);
			$('#pjt').html("");
			for(var i = 0; i < res.length; i++){
				txt += "<li>";
				txt += '<a href="/kogile/main">'+ res[i].pjt_title + '</a>';
				txt += "</li>";
			}
			$('#pjt').html(txt);
			
		}).catch(function(err){
			console.log(err);
		});
	}
	
	function insert_project(){
		var data = $("form[name=insert_project_form]").serialize();
		console.log(data);
		$.ajax({
			type : "POST",
			url : "/kogile/project/insert",
			data : data
		}).then(function(res){
			console.log(res);
		});
	}
	
	
})(jQuery)