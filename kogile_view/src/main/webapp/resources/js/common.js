(function($){
	//검색 관련 js
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

	
	var isSearch = false;
	
	$("input[name=search]").on('focusin', function(){
		isSearch =true;
	})
	
	$("input[name=search]").on('focusout', function(e){
		var searchValue = $('input[name=search]').val();
		
		searchListService.searchList({search:searchValue}, function(list){
			console.log(list);
			
			
			var value = "";
			
			for(var i = 0; i<list.length; i++){
				value += "<p><input class='btn btn-default' type='button' value='" +  list[i].no + " " + list[i].name + " " + list[i].mail 
				+ "' id='searchList'/></p>";
				console.log(value);
				
			}
			value2 = "검색결과 창을 닫으시려면 돋보기아이콘을 한번 더 클릭해주세요.";
			//value2 글자 크기 조절하기	
			value = value + value2;
			
			$('#btn-search').attr("data-content", value);	
		})
		
	});
	
	$(document).on("click", '#searchList', function(){
		yesNo();
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
	

	//알림관련 js
	
		//알림관련 js
		console.log("========");
		console.log("notice test");

		var noticeService = (function() {

			function notice(param, callback, error) {

				var notice = param.total_m_no;
				
				$.getJSON("/notice/noticeList/" + notice + ".json", 
			
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
				notice : notice
			};
		})();
			
			
		$("a[id=alertsDropdown]").on('click', function(e){
			//var noticeValue = ;
			
			var noticeValue = $('#rw').attr('value');
			var noticeUL = $("#notice3");
			
			noticeService.notice({total_m_no:noticeValue}, function(list){
				
				var value = '';
				
				if(list==null || list.length==0){
					noticeUL.html("");
					
					return;
				}
				
				for(var i = 0; i<list.length; i++){
					value += "<p class='dropdown-item notice_list'>"+ list[i].ntc_cont + " " + list[i].day + "</p>";
					//value += "<p>" + list[i].ntc_cont + " " + list[i].day + "</p>";
					
				}
				
				noticeUL.html(value);
			})
		
		});
		
		//초대관련 js
	
		//초대관련 js
		console.log("=============");
		console.log("invite test");

		var inviteService = (function() {
	
			//초대 목록 관련 js
			function invite(param, callback, error) {

				var invite = param.pjt_no;
				
				$.getJSON("/invite/inviteList/" + invite + ".json", 
				
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
				invite : invite
			};
		})();
			
			
		$(document).ready(function(){
			//var noticeValue = ;
			
			var inviteValue = $('#rw2').attr('value');
			var inviteUL = $("#pjname");
			
			inviteService.invite({pjt_no:inviteValue}, function(list){
				
				var value = '';
				
				if(list==null || list.length==0){
					inviteUL.html("");
					
					return;
				}
				
				for(var i = 0; i<list.length; i++){
					value += list[i].name + " ";
			
				}
				
				inviteUL.html(value);
			})
		
		});

		
		
//		채팅창 띄우기
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
