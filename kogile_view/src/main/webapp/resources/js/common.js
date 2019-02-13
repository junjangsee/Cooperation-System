(function ($){
	$(function(){
		// 김근열 js 소스
		// 검색 기능의 popover창
		// 검색 popover창
		$('[data-toggle="popover"]').popover()
		
		
		//채팅창띄우기.
		$("#messagesDropdown").on("click", function(){
		window.open("/Chatting","","width=356, height=450");
		return false;
	})
	});
})(jQuery)