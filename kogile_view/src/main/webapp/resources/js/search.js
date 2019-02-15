(function($) {
	console.log("search module......");

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
		console.log("search module2....");
		return {
			searchList : searchList 
		};
	})();
})(jQuery)