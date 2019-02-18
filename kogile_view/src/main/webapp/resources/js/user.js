/**
 * user관련 Ajax모듈
 */
var userService = (function() {
	console.log('userModuletest..');
	var url = {
		"login" : "/login/internal/login",
		"register" : "/login/internal/register",
		"logout" : "/login/internal/logout"
	};
	
	//pjt_no 어떻게 가져옴? 일단 임의로 넣어야함.

	function initChatCtn(pjt_no, callback, error) {
		$.ajax({
			type : 'get',
			url : url.initChatCtn + pjt_no,
			success : function(result, status, xhr) {
				if(callback){
					callback(result);
				}
			},
			error : function() {
				if(error) {
					error(er);
				}
			}
		})
	}
	
	//일정 시간마다 요청을 날려야함. 그리고 콜백에서 최근 채팅번호 업데이트 해야함.
	//데이터는 pjt_no랑 최신 채팅번호.
	function recievechat(userInfo, callback, error) {
		$.ajax({
			type : 'post',
			url : url.recievechat,
			data : JSON.stringify(userInfo),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(error) {
				error(er);
			}
		})
	}
	
	//버튼 클릭할때 이벤트 날리기.
	function sendchat(chat, callback, error) {
		$.ajax({
			type : 'post',
			url : url.sendchat,
			data : JSON.stringify(chat),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(error) {
				error(er);
			}
		})
	}

	return {
		"initChatCtn" : initChatCtn,
		"recievechat" : recievechat,
		"sendchat" : sendchat
	};
})();