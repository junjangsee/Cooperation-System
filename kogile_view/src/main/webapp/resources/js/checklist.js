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
	
	
})(jQuery)