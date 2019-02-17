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
					txt += `<li><a href="#" class="card_edit" id="${res[i].label_no}"></a><span class="red">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==2){
					txt += `<li><a href="#" class="card_edit" id="${res[i].label_no}"></a><span class="orange">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==3){
					txt += `<li><a href="#" class="card_edit" id="${res[i].label_no}"></a><span class="yellow">${res[i].label_text}</span></li>`;					
				}
				if(res[i].color_no ==4){
					txt += `<li><a href="#" class="card_edit" id="${res[i].label_no}"></a><span class="green">${res[i].label_text}</span></li>`;					
				}
			}
			txt += `</ul></div>`;
			txt += `<div class="dropdown-divider"></div>`;
			txt += `<a href="#">라벨 추가</a>`;
			$('#MY_btn_label').attr("data-content", txt);
		}).catch(function(err){
			console.log(err);
		})
	}
	
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
	
	
})(jQuery)