console.log("replyModule...................");

var replyService = (function() {
	
	
	$(function() {
		
		$(document).on("click", ".detailPostView.post.ui-state-default", function(){
			var p_no = $(this).find(".select_pno").val();
			$('#detail_post_modal').find('input[name=p_no]').val(p_no);
			
			replyService.showList();
			
		});
		
		
		$('#reply_save').on('click', function(){
			
			var reply= {
					"r_contents":$("#insert_reply").val(),
					"p_no":$("input[name=p_no]").val(),
					"info_no":1
			};
//			var p_no={
//					"p_no":$("input[name=p_no]").val()
//				}
			
			replyService.add(reply);
			
			$('#insert_reply').val("");
			return false;
		});
		
		$(document).on("click", ".fas.fa-trash-alt", function(){
			console.log("눌림")
			replyService.remove();
		});
		
		
		
		
	});
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
				replyService.showList();
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
					console.log('error');
				}
			}
		})
	}
	
	function remove() {
		var r_no = $(this).attr("data-rno");
		console.log(r_no);
		
		$.ajax({
			type : 'delete',
			url : '/kogile/reply/' + r_no,
			success : function(res) {
				console.log("성공 : " + r_no);
				replyService.showList();
				console.log(r_no);
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

	function showList() {
		var p_no = $('#detail_post_modal').find('input[name=p_no]').val();
		
		$.getJSON("/kogile/reply/"+p_no)
		.then(function(res){
			console.log(res);
			var txt='';
			
			for(var i =0;i<res.length;i++){
				txt +='<li>';
				txt +='<input type="hidden" name="r_no" value="'+res[i].r_no+'"/>'
				txt +='<span class="name">'+res[i].name.substring(res[i].name.length-2) +'</span>';
				txt +='<div class="input_box">'
				txt +='<span class="fullname">'+res[i].name+'</span><br>'
				txt +='<span class="date">'+ moment(res[i].r_date).format("YYYY-MM-DD")+'</span>'
				txt +='<a class="fas fa-edit" href="#"/><a class="fas fa-trash-alt" data-rno="'+res[i].r_no + '" href="#"/>'
				txt +='<span class="cts">'+res[i].r_contents+'</span>'
				txt += '</div>';
				txt += '</li>';
			}
			$('#reply_list').html(txt);

			
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
