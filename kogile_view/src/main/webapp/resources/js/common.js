
	console.log("========");
	console.log("js test");
	function yesNo(){
		var a = confirm("초대하시겠습니까?");
		if(a==true){
			alert("초대됐습니다.");
			}
		else{
			alert("초대가 취소됐습니다.");	
			return false;
		}
	}

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
		return {
			searchList : searchList 
		};
	})();
	$(function(){
	$("#btn-search").on('click', function(e) {
		event.stopPropagation();
		 
		var searchValue = $('input[name=search]').val();
		
		if(searchValue == "" || searchValue==null){
			alert("검색값을 입력해주세요.");
			target.removeEventListenter('input[name=search]', this); //이벤트 제거하여 popover이벤트 막기. 
																		//but 첫페이지로 이동하는 버그 발생..
			return;
		} 
		
		$(function(){searchListService.searchList({search:searchValue}, function(list){
			
			event.stopPropagation();
			
				var value = "";
				
				 for(var i = 0; i<list.length; i++){
					
					 	value += "<p><input class='btn btn-default' type='submit' value='" +  list[i].no + " " + list[i].name + " " + list[i].mail 
						  + "'data-toggle='button' onclick='return yesNo()'/></p>"; 
				
					} 

					$(function(){
						$('[data-toggle="popover"]').popover({
							html : true,
							placement : 'bottom'
						});
						
						$('#btn-search').attr("data-content", value);
					});
					
					
				
			});
		});
	});
	});


	// 채팅창띄우기.
	$("#messagesDropdown").on("click", function() {
		window.open("/Chatting", "", "width=356, height=450");
		return false;
	})
