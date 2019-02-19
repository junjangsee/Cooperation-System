(function($){

	listLabel();
	list_LabelInfo();
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
//		placement : 'bottom',
		
	});
	
//	해당프로젝트 라벨조회
	function listLabel(){
		var txt = ``;
		
		$.ajax({
			type : "GET",
			dataType : "JSON",
			url : "/kogile/label/list"
		}).then(function(res){
			txt += `<div class="label_list"><ul style="padding-left : 10px;">`;
			for(var i = 0; i < res.length; i++){
				if(res[i].color_no ==1){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="red btnLabel">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==2){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="orange btnLabel">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==3){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="yellow btnLabel">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==4){
					txt += `<li><a data-toggle="modal" data-target="#label_modal" href="#" class="card_edit" id="${res[i].label_no}"></a><span class="green btnLabel">${res[i].label_text}</span></li>`;					
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
			alert("라벨 생성 오류 발생");
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
	
//	UPDATE OR DELETE FORM
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
						dalcDday(date);
					}
					
			});
			
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
					alert('저장되었습니다.');
					$('#due_date').val(endDay);
				}).catch(function(err){
					console.error(err);
					alert('날짜를 다시 선택해주세요');
				})
			}

			
			// 디데이 작업 중
//			function calcDday(date) {
//				var date = $('#due_date').val();
//				console.log(date);
//				
//				$("#MY_btn_due").flatpickr({
//					
//					onChange: function(countDays) { 
//						
//						  var startDay = flatpickr.formatDate(new Date(),"m/d/Y");
//						  var endDay = flatpickr.formatDate("", "m/d/Y");
//
//						  var newStartDate = new Date(startDay).getTime();
//						  var newEndDate = new Date(endDay).getTime();
//							
//						  var newStartDate = eval( newStartDate / 1000 + 3600 ); // for GMT+1 I had to add 3600 (seconds) [1 hour]
//						  var newEndDate = eval( newEndDate / 1000 + 3600 ); // for GMT+1 I had to add 3600 (seconds) [1 hour]
//							
//						  var countDays = eval( newEndDate - newStartDate );
//						  var countDays = eval( countDays / 86400 + 1 );
//							
//						  console.log( '마감일 : ' + countDays + '일 남았습니다.');
//
//						  return countDays;
//						}
//				});
//			}
			
			// ----------------------------------------- End Post Date
			
//			--------- label 삭제
			$('#deleteLabel').on('click', function(){
				var label_no = $("input[name=label_no]").val();
				console.log(label_no);
				deleteLabel(label_no);
			})
			
			function deleteLabel(label_no){
				
				$.ajax({
					dataType : "html",
					type : "GET",
					url : `/kogile/label/delete/${label_no}`
				}).then(function(res){
					console.log(res);
					listLabel();
				}).catch(function(e){
					console.log(e);
				})
			}
//			label 삭제 -------------
			
//			----------label 수정
			$('#updateLabel').on('click', function(){
				updateLabel();
			})
			
			function updateLabel(){
				var label = $("form[name=label_info]").serializeObject();
				console.log(label);
				
				$.ajax({
					data : JSON.stringify(label),
					dataType : "text",
					type : "POST",
					url : '/kogile/label/update',
					contentType : "application/json; charset=UTF-8"
				}).then(function(res){
					console.log(res);
					listLabel();
				}).catch(function(e){
					console.log(e);
				})
			}
//			label 수정-----------
			
//			-------------lable 선택
			$(document).on('click', '.btnLabel' ,function(){
				var label_no = $(this).prev().attr("id");
				var p_no = $("input[name=p_no]").val();
				const data = {
						label_no : label_no,
						p_no : p_no
				}
				selectLabel(data);
			})
			
			function selectLabel(data){
				$.ajax({
					data : JSON.stringify(data),
					type : "POST",
					dataType : "text",
					url : "/kogile/label/selectLabel",
					contentType : "application/json; charset=UTF-8"
				}).then(function(res){
					console.log(res);
					list_LabelInfo();
				})
				
			}
//			label 선택----------------
			
//			------------------선택한 라벨 조회
			function list_LabelInfo(){
				var p_no = $("input[name=p_no]").val();
				
				$.ajax({
					type : "GET",
					dataType : "JSON",
					url : `/kogile/label/listLabelInfo/${p_no}`
				}).then(function(res){
					console.log(res);
					var txt = ``;
					
					$('#label_info_list').html("");
					$.each(res, function(i, item){
						if(item.color_no == 1){
							txt += `<li><span class="red cancelLabel">${item.label_text}</span><input type="hidden" value="${item.label_no}"/></li>`;
						}else if(item.color_no == 2) {
							txt += `<li><span class="orange cancelLabel">${item.label_text}</span><input type="hidden" value="${item.label_no}"/></li>`;
						}else if(item.color_no == 3) {
							txt += `<li><span class="yellow cancelLabel">${item.label_text}</span><input type="hidden" value="${item.label_no}"/></li>`;
						}else if(item.color_no == 4) {
							txt += `<li><span class="green cancelLabel">${item.label_text}</span><input type="hidden" value="${item.label_no}"/></li>`;
						}
					})
//					console.log(txt);
					$('#label_info_list').html(txt);
				}).catch(function(e){
					console.log(e);
				});
			}
			
//			선택한 라벨 조회------------------
			
//			------------------>선택라벨 삭제
			$(document).on('click', '.cancelLabel', function(){
				var label_no = $(this).next().val();
				var p_no = $('input[name=p_no]').val();
				const data = {
						label_no : label_no,
						p_no : p_no
				}
				
				cancelLabel(data);
			})
			
			function cancelLabel(data){
				$.ajax({
					data : JSON.stringify(data),
					type : "POST",
					contentType : "application/json; charset=UTF-8",
					dataType : "html",
					url : "/kogile/label/cancelLabel"
				}).then(function(res){
					console.log(res);
					list_LabelInfo();
				})
			}
//			선택라벨 삭제<------------------
			
})(jQuery)