console.log("descriptionModule...................");

var descriptionService = (function() {
	
	
	$(function() {
		
		//포스트상세보기 누르면 p_no를 가져와 디스크립션 보여준다. 이때 필요없는 수정창과 버튼 숨긴다
		$(document).on("click", ".detailPostView.post.ui-state-default", function(){
			var p_no = $(this).find(".select_pno").val();
			console.log(p_no);
			$('#description_modify').hide();
			$('#description_modify_btn').hide();
			descriptionService.showDescription();
		});
		//디스크립션누르면 수정창에 설명내용 뜨고 버튼 나타난다
		$('#description').on("click",function(){
			var txt = $(this).find('p').html();
			$('#description').find('p').hide();
			$('#description_modify').show();
			$('#description_modify').val(txt);
			$('#description_modify_btn').show();
		});
		//수정버튼 누르면 설명이 수정된다
		$('#description_modify_btn').on("click", function(){
			var description={"p_description":$('#description_modify').val()}
			descriptionService.updateDescription(description);
			
		})

	
	});

	function updateDescription(description) {
		description.p_no=$('#detail_post_modal').find('input[name=p_no]').val();
		console.log(description.p_no);
		$.ajax({
			type : 'put',
			url : '/kogile/post/description/' + description.p_no,
			data : JSON.stringify(description),
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				console.log("성공");
				descriptionService.showDescription();
				//버튼과 수정창을 숨겨준다
				$('#description_modify').hide();
				$('#description_modify_btn').hide();
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function showDescription() {
		var p_no = $('#detail_post_modal').find('input[name=p_no]').val();
		$.getJSON("/kogile/post/description/" + p_no + ".json")
		.then(function(res){
			console.log(res);
			var txt='';
				txt +='<p>';
				txt +=res.p_description;
				txt +='</p>';
				var txt2='';
				txt2 +='<p>';
				txt2 +='포스트설명...';
				txt2 +='</p>';
				
				if(res.p_description==null){
					$('#description').find('div').html(txt2);
				}else{
					$('#description').find('div').html(txt);
				}
			
		}).catch(function(err){
			console.log(err);
		});
		
	}

	return {
		updateDescription : updateDescription,
		showDescription : showDescription
	};

})();
