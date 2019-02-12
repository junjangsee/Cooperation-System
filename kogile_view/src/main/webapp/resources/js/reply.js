//console.log("reply Module........");

var replyService = (function() {
//console.log("test");
	function add(reply) {
		console.log("add reply...............");

		$.ajax({
			type : 'post',
			url : '/kogile/reply/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				console.log(res);
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
					console.log('error');
				}
			}
		})
	}
	
	function remove(r_no) {
		$.ajax({
			type : 'delete',
			url : '/kogile/reply/' + r_no,
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

	function update(reply) {

		$.ajax({
			type : 'put',
			url : '/kogile/reply/' + reply.r_no,
			data : JSON.stringify(reply),
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

	function showList(p_no) {
		
		$.getJSON("/kogile/reply/" + p_no + ".json")
		.then(function(res){
			console.log(res);
			var txt='';
			for(var i =0;i<res.length;i++){
				txt +='<li>';
				txt +=res[i].r_contents + res[i].name + res[i].r_date
				txt +='</li>'
			}
			$('#ex').html(txt);
		}).catch(function(err){
			console.log(err);
		});
		
	}

	return {
		add : add,
		showList : showList,
		remove : remove,
		update : update
	};

})();
