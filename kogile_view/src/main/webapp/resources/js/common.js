(function($) {
	// 김근열 js 책소스(나중에 밑에 js소스랑 취합)
	console.log("========");
	console.log("js test");
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
	$(function() {
		$("#btn-search").on(
				'click',
				function(e) {
					e.preventDefault();

					var searchValue = $('input[name=search]').val();
					var searchUL = $(".chat");

					console.log(searchValue);

					searchListService.searchList({
						search : searchValue
					}, function(list) {

						var value = "";

						if (list == null || list.length == 0) {
							searchUL.html("");

							return;
						}
						for (var i = 0; i < list.length; i++) {

							value += list[i].no + " " + list[i].name + " "
									+ list[i].mail + "<br>";

						}

						$('[data-toggle="popover"]').popover({
							html : true,
							placement : 'bottom'
						});

						$('#btn-search').attr("data-content", value);

					});
				});
	});


	// 채팅창띄우기.
	$("#messagesDropdown").on("click", function() {
		window.open("/Chatting", "", "width=356, height=450");
		return false;
	})

})(jQuery)