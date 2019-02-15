(function($){
	$(function(){
		listLabel();
//		$('#MY_btn_label').on('click', function(){
//			return false;
//		})
		
		$('#MY_btn_label').popover({
			html : true,
			container : 'body',
//			placement : 'bottom',
			
		});
	});
	
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
	
})(jQuery)