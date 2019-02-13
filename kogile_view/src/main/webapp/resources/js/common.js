(function($) {
	$(function() {
		// 김근열 js 소스
		// 검색 기능의 popover창
		// 검색 popover창
		$("#btn-search").on('click', function(e) {
			e.preventDefault();
			search_toggle();
		});

		// 채팅창띄우기.
		$("#messagesDropdown").on("click", function() {
			window.open("/Chatting", "", "width=356, height=450");
			return false;
		})
	});

	function search_toggle() {
		var searchKey = $('input[name=search]').val();
		$('#btn-search').attr("data-content", searchKey)
		console.log(searchKey);
		
		$('[data-toggle="popover"]').popover({
			html : true,
			placement : 'bottom'
		});

/*		 $.ajax({
		 data : searchKey,
		 type : "POST",
		 dataType : "JSON",
		 url : "/kogile/invite/search"
		 }).then(function(res){
		 console.log(res);
		 var txt = ``;
		 txt += `<a href="#">res.mail</a>`;
		 $('input[name=search]').attr("data-content", txt);
				
		 $('[data-toggle="popover"]').popover({
		 html : true,
		 });
		 })*/

	}

})(jQuery)