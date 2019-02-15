<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>


<title>Insert title here</title>
<style type="text/css">
@CHARSET "EUC-KR";

.mytext {
	border: 0;
	padding: 10px;
	background: whitesmoke;
}

.text {
	width: 75%;
	display: flex;
	flex-direction: column;
}

.text>p:first-of-type {
	width: 100%;
	margin-top: 0;
	margin-bottom: auto;
	line-height: 13px;
	font-size: 12px;
}

.text>p:last-of-type {
	width: 100%;
	text-align: right;
	color: silver;
	margin-bottom: -7px;
	margin-top: auto;
}

.text-l {
	float: left;
	padding-right: 10px;
}

.text-r {
	float: right;
	padding-left: 10px;
}

.avatar {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 25%;
	float: left;
	padding-right: 10px;
}

.macro {
	margin-top: 5px;
	width: 85%;
	border-radius: 5px;
	padding: 5px;
	display: flex;
}

.msj-rta {
	float: right;
	background: whitesmoke;
}

.msj {
	float: left;
	background: white;
}

.frame {
	background: #e0e0de;
	height: 450px;
	overflow: hidden;
	padding: 0;
}

.frame>div:last-of-type {
	position: absolute;
	bottom: 0;
	width: 100%;
	display: flex;
}

body>div>div>div:nth-child(2)>span {
	background: whitesmoke;
	padding: 10px;
	font-size: 21px;
	border-radius: 50%;
}

body>div>div>div.msj-rta.macro {
	margin: auto;
	margin-left: 1%;
}

ul {
	width: 100%;
	list-style-type: none;
	padding: 18px;
	position: absolute;
	bottom: 47px;
	display: flex;
	flex-direction: column;
	top: 0;
	overflow-y: scroll;
}

.msj:before {
	width: 0;
	height: 0;
	content: "";
	top: -5px;
	left: -14px;
	position: relative;
	border-style: solid;
	border-width: 0 13px 13px 0;
	border-color: transparent #ffffff transparent transparent;
}

.msj-rta:after {
	width: 0;
	height: 0;
	content: "";
	top: -5px;
	left: 14px;
	position: relative;
	border-style: solid;
	border-width: 13px 13px 0 0;
	border-color: whitesmoke transparent transparent transparent;
}

input:focus {
	outline: none;
}

::-webkit-input-placeholder { /* Chrome/Opera/Safari */
	color: #d4d4d4;
}

::-moz-placeholder { /* Firefox 19+ */
	color: #d4d4d4;
}

:-ms-input-placeholder { /* IE 10+ */
	color: #d4d4d4;
}

:-moz-placeholder { /* Firefox 18- */
	color: #d4d4d4;
}
</style>
<script type="text/javascript">
/**
 * 채팅 관련 Ajax 모듈.
 */
var chatService = (function() {
	var url = {
		"initChatCtn" : "/chat/initChatCtn/",
		"recievechat" : "/chat/recievechat",
		"sendchat" : "/chat/sendchat"
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
</script>

<script type="text/javascript">

	function ChatVO(chatContents, pjt_no, total_m_no, writer) {
		this.chatContents = chatContents;
		this.pjt_no = pjt_no;
		this.total_m_no = total_m_no;
		this.writer = writer;
		}

	//향후 파라미터로 건네받습니다.
	var MyChatInfo = {
		"pjt_no" : 1,
		"name" : "황소현",
		"total_m_no" : 2,
		"chat_no" : 1
		};	
	
	//최초1회 모든 채팅리스트를 다 가져온다.
	printChat();
	chatService.initChatCtn(MyChatInfo.pjt_no);
	//지속적으로 채팅리스트를 업데이트 한다.
	setInterval(function() {
		printChat();
	}, 1000);
	//Ajax요청을 날린후, 화면에 뿌려준다.
	function printChat() {
		chatService.recievechat(window.MyChatInfo, function(chatList){
			
			//새로운 채팅내용만 불러오기 위해서 지속적으로 마지막 채팅넘버를 업데이트 한다.
			if(chatList.length > 0) {
				window.MyChatInfo.chat_no = chatList[chatList.length - 1].chat_no;
				chatList.forEach(function (chat, index, array) {
					
					var who;
					// total_m_no로 내채팅인지 확인한다.
					if(chat.total_m_no == window.MyChatInfo.total_m_no){
						who = "me"; 
					}else{
						who = "other";
					}
					insertChat(who, chat);
				});
			}

		});
	}
	
	$(function() {

		$(".mytext").on("keydown", function(e) {
			if (e.which == 13) {
				var text = $(this).val();
				if (text !== "") {
					//var member_info = "<%=(String) session.getAttribute("memberInfo")%>";

							var chat = new ChatVO(text,
									window.MyChatInfo.pjt_no,
									window.MyChatInfo.total_m_no,
									window.MyChatInfo.name);
							chatService.sendchat(chat);
							$(this).val('');
						}
					}
				});

		//버튼을 입력하면 위와 동일한 이벤트가 발생한다.
		$('body > div > div > div:nth-child(2) > span').click(function() {
			$(".mytext").trigger({
				type : 'keydown',
				which : 13,
				keyCode : 13
			});
		})
	})
</script>
<script type="text/javascript">
	function insertChat(who, ChatVo) {

		var control = "";
		//실질적으로 채팅 뿌려주는 코드.
		if (who == "other") {
			control = '<li style="width:100%">' + '<div class="msj macro">'
					+ '<div class="text text-l">' + '<p><b>' + ChatVo.writer
					+ '</b></p>' + '<p>' + ChatVo.chatContents + '</p>'
					+ '<p><small>' + ChatVo.regdate + '</small></p>' + '</div>'
					+ '</div>' + '</li>';
		} else {
			control = '<li style="width:100%;">' + '<div class="msj-rta macro">'
					+ '<div class="text text-r">' + '<p><b>' + ChatVo.writer
					+ '</b></p>' + '<p>' + ChatVo.chatContents + '</p>' +
					'<p><small>' + ChatVo.regdate + '</small></p>' + '</div>'
					+ '</div>' + '</li>';
		}

		//목록에 append
		$("ul").append(control).scrollTop($("ul").prop('scrollHeight'));

	}

	//화면 비우기
	function resetChat() {
		$("ul").empty();
	}
	resetChat();
	//-- Clear Chat

	//일정시간마다 Ajax요청을 날려서 새로운 메시지가 있는지 확인한다.
</script>
</head>
<body>
	<div class="col-sm-3 col-sm-offset-4 frame">
		<ul id="chatScreen"></ul>
		<div>
			<div class="msj-rta macro">
				<div class="text text-r" style="background: whitesmoke !important">
					<input class="mytext" id="chatInput" placeholder="Type a message" />
				</div>

			</div>
			<div id="sendDiv" style="padding: 10px;">
				<span class="glyphicon glyphicon-share-alt"></span>
			</div>
		</div>
	</div>
</body>

</html>