(function ($){
	$(function(){
		list();
		
		$('#insert_project').on('click', function(){
			insert_project();
		});
	});
	
	function list(){
		var txt = "";
		
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : "/kogile/project/list_project",
		}).then(function(res){
			console.log(res);
			$('#pjt').html("");
			for(var i = 0; i < res.length; i++){
				txt += "<li>";
				txt += '<a href="/kogile/main?pjt_no='+ res[i].pjt_no +'">'+ res[i].pjt_title + '</a>';
				txt += "</li>";
			}
			$('#pjt').html(txt);
			
		}).catch(function(err){
			console.log(err);
		});
	}
	
	function insert_project(){
		const data = $("form[name=insert_project_form]").serialize();
		console.log(data);
		
		$.ajax({
			type : "POST",
			url : "/kogile/project/insert",
			data : data,
			dataType : "JSON"
		}).then(function(res){
			console.log(res);
			list();
//			txt += "<li>";
//			txt += '<a href="/kogile/main">' + res.pjt_title + '</a>';
//			txt += "</li>";
//			console.log(txt);
//			
//			$('#pjt').append(txt);
		});
	}
	
	
})(jQuery)