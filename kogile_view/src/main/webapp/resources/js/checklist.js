//
//
///* return {name: "AAAAB"} */
//
///*
// * function add(check_title, callback){ console.log("check_title...." +
// * check_title);
// *  } return {add:add};
// */
//console.log("Checklist ... Module")
//
//var checklistService = (function() {
//
//	function add(check_title, callback, error) {
//		/*console.log("add check_title...")*/
//
//		$.ajax({
//			type : 'post',
//			url : '/checklist/new',
//			data : JSON.stringify(check_title),
//			contentType : "application/json; charset=utf-8",
//			success : function(result, status, xhr) {
//				if (callback) {
//					callback(result);
//				}
//			},
//			error : function(xhr, status, er) {
//				if (error) {
//					error(er);
//				}
//			}
//		})
//	}
//	
//	
//	return {
//		add : add
//	}
//})();
//
//checklistService.add({
//	check_title : "check_title들어가라02",
//	p_no : 1
//}, function(result) {
//	alert("Result: " + pnoValue);
//}
//);
//
(function($){
	$(function(){
		$('#insertCheck').on('click', function(){
			insertCheck();
		})
	});
	
	function insertCheck(){
		const data= {
				p_no : $('#p_no').val(),
				check_title : $("input[name=check_title]").val()
		};
		
		console.log(data);
		
		$.ajax({
			contentType : "application/json; charset=utf-8", 
			data : JSON.stringify(data),
			type : 'POST',
			dataType : 'JSON',
			url : "/kogile/checklist/new"
		}).then(function(res){
			console.log("성공");
		}).catch(function(e){
			console.log(e);
		});
	}
	
})(jQuery)