(function($){

	listLabel();
	// $('#MY_btn_label').on('click', function(){
	// return false;
	// })
			
			$('#MY_btn_label').popover({
				html : true,
				container : 'body',
	// placement : 'bottom',
			})
	
	$('#MY_btn_label').popover({
		html : true,
		container : 'body',
// placement : 'bottom',
		
	});
	
// 해당프로젝트 라벨조회
	function listLabel(){
		var txt = ``;
		
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : "/kogile/label/list"
		}).then(function(res){
			txt += `<div class="label_list"><ul>`;
			for(var i = 0; i < res.length; i++){				
				if(res[i].color_no ==1){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="red">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==2){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="orange">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==3){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="yellow">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==4){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="green">${res[i].label_text}</span></li>`;					
				}
			}
			txt += `</ul></div>`;
			txt += `<div class="dropdown-divider"></div>`;
			txt += `<a id="insertLabelForm" href="#" data-toggle="modal" data-target="#label_modal">라벨 추가</a>`;
			$('#MY_btn_label').attr("data-content", txt);
		}).catch(function(err){
			console.log(err);
		})
	}
	
	$(document).on('click', '#insertLabelForm', function(){
		btnInsertLabel();
		return false;
	})
	
	$('#insertLabel').on('click', function(){
		const data = $("form[name=label_info]").serializeObject();
		console.log(data);
		
		$.ajax({
			data : JSON.stringify(data),
			type : "POST",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			url : "/kogile/label/insert"
		}).then(function(res){
			listLabel();
		}).catch(function(e){
			console.log(e);
		})
	})
	
	jQuery.fn.serializeObject = function() { 
		var obj = null; 
		try {
			if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
				var arr = this.serializeArray(); 
				if(arr){
					obj = {}; 
					jQuery.each(arr, function() { 
						obj[this.name] = this.value; 
						});
					}
				}
			}catch(e) { 
				alert(e.message); 
			}finally {
				
			} 
			return obj; 
	}
	
// UPDATE OR DELETE FORM
	function btnInsertLabel(){
		$('.modal-title').html("라벨 생성");
		$('.updateLabel').hide();
		$('.insertLabel').show();
		$('input[name=label_text]').val("");
		$('.labelcolor_red').prev().prop("checked", true);
	};
	
	
	function btnUpdateLabel(){
		$('.modal-title').html("라벨 수정/삭제");
		$('.insertLabel').hide();
		$('.updateLabel').show();
	};
	
	$(document).on('click', '.card_edit', function(){
		btnUpdateLabel();
		var label_no = $(this).attr("id");
		
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : `/kogile/label/detail/${label_no}`
		}).then(function(res){
			console.log(res);
			$("input[name=label_no]").val(res.label_no);
			$("input[name=label_text]").val(res.label_text);
			if(res.color_no == 1){
				$('.labelcolor_red').prev().prop("checked", true);
			}
			if(res.color_no == 2){
				$('.labelcolor_orange').prev().prop("checked", true);
			}
			if(res.color_no == 3){
				$('.labelcolor_yellow').prev().prop("checked", true);
			}
			if(res.color_no == 4){
				$('.labelcolor_green').prev().prop("checked", true);
			}
			
		}).catch(function(e){
			console.log(e);
		});
	});
			// ----------------------------------------- start Post Date

			$("#MY_btn_due").flatpickr({
			
					minDate: "today",
					onChange: function(date) {
						
						var id = $('#p_no').val();
						
						var endDay = flatpickr.formatDate(date[0], "Y-m-d");
						update_Date(endDay, id);
					}
					
			});
			
			$('#due_date').on('focusout', function(){
				var id = $('#p_no').val();
				update_Date($(this).val(), id);
			});
			
			$('#due_date').on('keyup', function(e){
				var id = $('#p_no').val();
				if(e.keyCode === 13){
					update_Date($(this).val(), id);
				} else {
					// Nothing
				}
			})
			
			
			function update_Date(endDay, id) {
				
				$.ajax({
					type : "POST",
					url : "/kogile/post/updatePostDate",
					data : JSON.stringify({
						p_dday: endDay,
						p_no : parseInt(id, 10)
					}),
					contentType : "application/json; charset=UTF-8"
				}).then(function(res){
					$('#due_date').val(endDay);
				}).catch(function(err){
					console.error(err);
				})
			}
			
			// 삭제하기 클릭 시 마감일 삭제하기
			$('#delete_date').on('click', function(){
				
				var id = $('#p_no').val();
				var date = $('#due_date').val();
				
				if ($('#due_date').val() == '') {
					alert('삭제할 마감일이 없습니다.');
				} else {
					delete_Date(date, id);
					alert('삭제되었습니다.');
				}
				
			})
			
			function delete_Date(date, id) {
				
				$.ajax({
					type : "POST",
					url : "/kogile/post/updatePostDate",
					data : 
						JSON.stringify({
						p_dday: "",
						p_no : parseInt(id, 10)
					}), 
					dataType : "JSON",
					contentType : "application/json; charset=UTF-8"
				}).then(function(res){
					$('#due_date').val('');
				}).catch(function(err){
					console.error(err);
				})
			}
			
			// ----------------------------------------- End Post Date

			// ----------------------------------------- Start update Title
			
			
			$('#title').on('focusout', function(){
				var id = $('#p_no').val();
				console.log(id);
				update_title($(this).val(), id);
			})
			
			$('#title').on('keyup', function(e){
				var id = $('#p_no').val();
				console.log(id);
				if (e.keyCode === 13) {
					update_title($(this).val(), id)
				}
			})
	
			
			function update_title(title, id) {
					$.ajax({
						type : "PATCH",
						url : "/kogile/post/updatePostTitle",
						data : JSON.stringify({
							p_title : title,
							p_no : parseInt(id, 10)
						}),
						contentType : "application/json; charset=UTF-8"
					}).then(function(res){
						$('#title').text(title);
						$('#title_header').text(title);
					}).catch(function(err){
						console.error(err);
					})
			}
			
			
			// ----------------------------------------- End update Title
			
			
			// ----------------------------------------- Start update
			// Desctiption
			
			$('#detail_description').on('focusout', function(){
				var id = $('#p_no').val();
				update_description($(this).val(), id);
			})
			
			$('#detail_description').on('keyup', function(e){
				var id = $('#p_no').val();
				if (e.keyCode === 13) {
					update_description($(this).val(), id);
				}
			})
			
			function update_description(description, id) {
				var p_no = $('#p_no').val();
				
				$.ajax({
					type : "PATCH",
					url : `/kogile/post/description/${p_no}`,
					data : JSON.stringify({
						p_description : description,
						p_no : parseInt(id, 10)
					}),
					contentType : "application/json; charset=UTF-8"
				}).then(function(res){
					$('#detail_description').text(description);
				}).catch(function(err){
					console.error(err)
				})
			}
			
			// ----------------------------------------- End update Desctiption
	
			
})(jQuery)