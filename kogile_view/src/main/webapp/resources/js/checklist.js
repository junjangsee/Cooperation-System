//
//
///* return {name: "AAAAB"} */
//
///*
// * function add(check_title, callback){ console.log("check_title...." +
// * check_title);
// *  } return {add:add};
// */
//console.log("Checklist ... Module")
//
//var checklistService = (function() {
//
//	function add(check_title, callback, error) {
//		/*console.log("add check_title...")*/
//
//		$.ajax({
//			type : 'post',
//			url : '/checklist/new',
//			data : JSON.stringify(check_title),
//			contentType : "application/json; charset=utf-8",
//			success : function(result, status, xhr) {
//				if (callback) {
//					callback(result);
//				}
//			},
//			error : function(xhr, status, er) {
//				if (error) {
//					error(er);
//				}
//			}
//		})
//	}
//	
//	
//	return {
//		add : add
//	}
//})();
//
//checklistService.add({
//	check_title : "check_title들어가라02",
//	p_no : 1
//}, function(result) {
//	alert("Result: " + pnoValue);
//}
//);
//
(function($){
//	--------------------------checklist 
	
//	list_checklist();
//	
//	function list_checklist(){
//		var p_no = $('#p_no').val();
//		
//		$.ajax({
//			type : "GET",
//			url : `/kogile/checklist/readChecklist/${p_no}`,
//			dataType : "JSON"
//		}).then(function(res){
//			console.log(res);
//			txt = ``;
//			for(var i = 0; i < res.length; i ++){
//				txt += `<div class="check" data-chno="${res[i].checklist_no}"><h5 class="check_title" style="display:inline;">* ${res[i].check_title}</h5><a href="#" id="delete_check" style="margin-left:10px; font-size : 15px;">삭제</a>`;
//				txt += `<input type="text" class="form-control check_title_form" style="display : none; margin-bottom : 3px; height : 30px;"
//				value="${res[i].check_title}">
//				<div class="progress">
//			<div class="progress-bar" role="progressbar" style="width: 0%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
//			</div><ul id="check_${res[i].checklist_no}" style="list-style :none;padding-left : 5px;"></ul>
//			 <a class="btn btn-primary btn-sm btn_addList" style="margin-top : 6px;color : #fff;">+</a></div><br>`;
//			}
//			$('#list_Checklist').html(txt);
//			
//			return res;
//		}).then(function(res){
//			console.log(res);
//			for(var i = 0; i < res.length; i ++){
//				listList(res[i].checklist_no);						
//			}
//			return res;
//		}).then(function(res){
//			$.each(res, function(i, item){
//				percent(item.checklist_no);
//			})
//		})
//	}
//	
//	$(document).on('click', '#delete_check', function(){
//		var checklist_no = $(this).closest('div').data('chno');
//		delete_check(checklist_no);
//		return false;
//	})
//	
//	function delete_check(checklist_no){
//		$.ajax({
//			type : "GET",
//			dataType : "text",
//			url : `/kogile/checklist/delete_check/${checklist_no}`
//		}).then(function(res){
//			console.log(res);
//			list_checklist();
//		})
//	}
//	
//	$('#insertCheck').on('click', function(){
//		insertCheck();
//	})
//	
//	function insertCheck(){
//		const data= {
//				p_no : $('#p_no').val(),
//				check_title : $("input[name=check_title]").val()
//		};
//		
//		console.log(data);
//		
//		$.ajax({
//			contentType : "application/json; charset=utf-8", 
//			data : JSON.stringify(data),
//			type : 'POST',
//			dataType : 'JSON',
//			url : "/kogile/checklist/new"
//		}).then(function(res){
//			console.log("성공");
//			list_checklist();
//		}).catch(function(e){
//			console.log(e);
//		});
//	}
//	
//	$(document).on('click', '.check_title', function(){
//		$(this).hide();
//		$(this).next().hide();
//		$(this).siblings('.check_title_form').show();
//		$(this).siblings('.check_title_form').focus();
//		var checklist_no = $(this).parent().data('chno');
//		console.log(checklist_no);
//	})
//	
//	$(document).on('focusout', '.check_title_form', function(){
//		var check_title = $(this).val();
//		var checklist_no = $(this).closest('div').data('chno');
//		var check = {
//				check_title : check_title,
//				checklist_no : checklist_no
//		};
//		updateCheck(check);
//	})
//	
//	function updateCheck(check){
//		$.ajax({
//			data : JSON.stringify(check),
//			type : "POST",
//			dataType : "text",
//			contentType : "application/json; charset=UTF-8",
//			url : "/kogile/checklist/update"
//		}).then(function(res){
//			console.log(res);
//			list_checklist();
//		})
//	}
//	
////	checklist----------------------------
//	
////	---------------------------checklist_list
//	
//	$(document).on('click', '.btn_addList', function(){
//		var txt = `<input type="text" class="form-control list_form" placeholder="리스트 내용" style="margin-top : 6px;">`;
//		$(this).before(txt);
//		$(this).prev().focus();
//	})
//	
//	$(document).on('focusout', '.list_form', function(){
//		var checklist_no = $(this).closest('div').data('chno');
//		var list_info = $(this).val();
//		
//		var data = {
//				checklist_no : checklist_no,
//				list_info : list_info
//		}
//		insertList(data);
//		
//	})
//	
//	function insertList(data){
//		$.ajax({
//			data : JSON.stringify(data),
//			type : "POST",
//			contentType : "application/json; charset=UTF-8",
//			dataType : "text",
//			url : "/kogile/checklist/insertList"
//		}).then(function(res){
//			console.log(res);
//			list_checklist();
//		})
//	}
//	
//	function listList(checklist_no){
//		$.ajax({
//			type : "GET",
//			dataType : "JSON",
//			url : `/kogile/checklist/listList/${checklist_no}`
//		}).then(function(res){
//			console.log(res);
//			$.each(res, function(i, item){
//				console.log(item);
//				var txt =``;
//				if(item.checked == 0){
//					txt += `<li data-lno="${item.list_no}"><input class="list_check" type="checkbox" value="1"><a class="MYlist_info">${item.list_info}</a><a href="#" class="delete_list" style="font-size : 10px; margin-left:5px;">삭제</a>
//					<input type="text" class="form-control list_info_form" value="${item.list_info}" style="display : none; margin-top : 5px;" ></li>`;
//				}else{
//					txt += `<li data-lno="${item.list_no}"><input class="list_check" type="checkbox" value="0" checked><a class="MYlist_info">${item.list_info}</a><a href="#" class="delete_list" style="font-size : 10px; margin-left:5px;">삭제</a>
//						<input type="text" class="form-control list_info_form" value="${item.list_info}" style="display : none; margin-top : 5px;" ></li>`;
//				}
//				$('#check_'+item.checklist_no).append(txt);
//			});
//				
//		})
//	}
//	$(document).on('click', '.delete_list', function(e){
//		e.preventDefault();
//		var list_no = $(this).closest('li').data('lno');
//		console.log(list_no);
//		deleteList(list_no);
//	})
//	
//	
//	function deleteList(list_no){
//		$.ajax({
//			type : "GET",
//			dataType : "text",
//			url : `/kogile/checklist/deleteList/${list_no}`
//		}).then(function(res){
//			console.log(res);
//			list_checklist();
//		})
//	}
//	
//	$(document).on('click', '.MYlist_info', function(){
//		$(this).prev().hide();
//		$(this).hide();
//		$(this).next().hide();
//		$(this).siblings('.list_info_form').show();
//		$(this).siblings('.list_info_form').focus();
//		
//	})
//	
//	$(document).on('focusout', '.list_info_form', function(){
//		var list_no = $(this).closest('li').data('lno');
//		var list_info = $(this).val();
//		
//		var data = {
//				list_no : list_no,
//				list_info : list_info
//		}
//		updateList(data);
//		
//		console.log(data);
//	})
//	
//	function updateList(data){
//		$.ajax({
//			data : JSON.stringify(data),
//			contentType : "application/json; charset=UTF-8",
//			type : "POST",
//			dataType : "text",
//			url : "/kogile/checklist/updateList"
//		}).then(function(res){
//			console.log(res);
//			list_checklist();
//		}).catch(function(e){
//			console.log(e);
//		})
//	}
//	
////	checkList_list-----------------------------
//	
//	//--------------------->check 처리
//	
//	$(document).on('change', '.list_check', function(){
//		var data = {
//				checked : $(this).val(),
//				list_no : $(this).closest('li').data('lno')
//		};
//		
//		updateCheck(data);
//		
//	})
//	
//	function updateCheck(data){
//		$.ajax({
//			data : JSON.stringify(data),
//			type : "POST",
//			dataType : "text",
//			contentType : "application/json; charset=UTF-8",
//			url : "/kogile/checklist/updateCheck"
//		}).then(function(res){
//			console.log(res);
//			list_checklist();
//		})
//	}
//	
//	
//	function percent(chno){
//		$.ajax({
//			type : "GET",
//			dataType : "JSON",
//			url : `/kogile/checklist/percent/${chno}`
//		}).then(function(res){
//			console.log(res.checklist_no);
//			$('#check_'+res.checklist_no).siblings('.progress').find('.progress-bar').css('width', res.completePercent+"%");
//			
////			$('#check_'+res.chekclist_no).closest('.progress-bar').css('width', res.completePercent);
//		})
//	}
				
	//check 처리<---------------------
	
})(jQuery)