console.log("Post Module........");

var postService = (function() {
//console.log("test");

	function updateDescription(description) {

		$.ajax({
			type : 'put',
			url : '/kogile/post/description/' + description.p_no,
			data : JSON.stringify(description),
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				console.log("성공");
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function showDescription(p_no) {
		
		$.getJSON("/kogile/post/description/" + p_no + ".json")
		.then(function(res){
			console.log(res);
			var txt='';
				txt +='<li>';
				txt +=res.p_description
				txt +='</li>'
			$('#ex2').html(txt);
		}).catch(function(err){
			console.log(err);
		});
		
	}

	return {
		updateDescription : updateDescription,
		showDescription : showDescription
	};

})();
