(function($){
	console.log("========");
	console.log("common js");
	
	function yesNo(){
		var a = confirm("초대하시겠습니까?");
		if(a==true){
			alert("초대됐습니다.");
		}
		else{
			alert("초대가 취소됐습니다.");	
			return false;
		}
	}
	
	var searchListService = (function() {

		function searchList(param, callback, error) {

			var search = param.search;
			
			$.getJSON("/invite/searchList/" + search + ".json", 
		
			function(data) {
				if (callback) {
					callback(data);
				}
			}).fail(function(xhr, status, err) {
				if (error) {
					error();
				}
			});
		}
		return {
			searchList : searchList 
		};
	})();
	
//	검색
	var isSearch = false;
	
	$("input[name=search]").on('focusin', function(){
		isSearch =true;
	})
	
	$("input[name=search]").on('focusout', function(e){
		var searchValue = $('input[name=search]').val();
//		
		searchListService.searchList({search:searchValue}, function(list){
			console.log(list);
			var value = "";
			
			for(var i = 0; i<list.length; i++){
				value += "<p><input class='btn btn-default' type='submit' value='" +  list[i].no + " " + list[i].name + " " + list[i].mail 
				+ "'data-toggle='button' onclick='return yesNo()'/></p>";
			}
			
			$('#btn-search').attr("data-content", value);	
		})
		
	});
	
	$('#btn-search').popover({
		html : true,
		placement : 'bottom'
	})
	
	$("#btn-search").on('click', function(e) {
		var searchValue = $('input[name=search]').val();
		if(searchValue == "" || searchValue==null){
			alert("검색값을 입력해주세요.");
			$(this).popover('hide');
//			$(this).removeEventListenter('input[name=search]'); //이벤트 제거하여 popover이벤트 막기. 															//but 첫페이지로 이동하는 버그 발생..
			return;
		} else{
			$(this).popover();
		}
							
	});
	
//	채팅창 띄우기
	$("#messagesDropdown").on("click", function() {
		window.open("/Chatting", "", "width=356, height=450");
		return false;
	})
	
})(jQuery);

//	
//	$(function(){
//		
//		
//		$("#btn-search").on('click', function(e) {
//			event.stopPropagation();
//			
//			 
//			var searchValue = $('input[name=search]').val();
//			
//			if(searchValue == "" || searchValue==null){
//				alert("검색값을 입력해주세요.");
//				target.removeEventListenter('input[name=search]', this); //이벤트 제거하여 popover이벤트 막기. 
//																			//but 첫페이지로 이동하는 버그 발생..
//				return;
//			} else{
//				$(function(){
//					$('[data-toggle="popover"]').popover({
//						html : true,
//						placement : 'bottom'
//					});
//					
//				});			
//			}
//								
//		});
//		
//	});
//
//	// 채팅창띄우기.
//	$("#messagesDropdown").on("click", function() {
//		window.open("/Chatting", "", "width=356, height=450");
//		return false;
//	})
