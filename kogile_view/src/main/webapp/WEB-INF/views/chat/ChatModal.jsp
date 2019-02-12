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
	console.log('chatModuletest..');
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
					console.log(result);
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
//ChatVo 생성자
function ChatVO(chatContents, pjt_no, total_m_no, writer) {
	this.chatContents = chatContents;
	this.pjt_no = pjt_no;
	this.total_m_no = total_m_no;
	this.writer = writer;
	}
//전역변수
var chatInfo = {
		"pjt_no" : 1,
		"name" : "soheemon",
		"total_m_no" : 1,
		"chat_no" : 1
	};
//이벤트 핸들러 등독
	$(function() {
		//이거 init시 초기화 하는 함수 만들기.
		//엔터를 입력하면 내용을 insertChat에 Data로 보낸다.
		$(".mytext").on("keydown", function(e) {
			if (e.which == 13) {
				var text = $(this).val();
				if (text !== "") {
					//var member_info = "<%=(String) session.getAttribute("memberInfo")%>";

					var chat = new ChatVO(text, pjt_no, total_m_no, name);
					chatService.sendchat(chat);
					//callback에는 list요청이 들어가있습니다
					//그리고 insertChat을 뿌려줍니다.
					//그게머냐면 total_m_no가 나랑일치하면 you
					//나랑 일치하지않으면 me를 넣습니다!
					//insertChat("you", text);
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
		printChat();
		
		//Ajax요청을 날린다릿. 결과를 list로 받아온다.
		function printChat() {
			//console.log(chatInfo.name);
			chatService.recievechat(this.chatInfo, function(chatList){
				//var chatList = JSON.parse(chatListJson);
				//console.log(chatListJson);
				chatList.forEach(function (chat, index, array) {
					//var chat = JSON.parse(chatjson);
					insertChat("me", chat.chatContents);
				});

			});
		}

	})

</script>
<script type="text/javascript">
	var me = {};
	me.avatar = "https://lh6.googleusercontent.com/-lr2nyjhhjXw/AAAAAAAAAAI/AAAAAAAARmE/MdtfUmC0M4s/photo.jpg?sz=48";

	var you = {};
	you.avatar = "https://a11.t26.net/taringa/avatares/9/1/2/F/7/8/Demon_King1/48x48_5C5.jpg";

	function formatAMPM(date) {
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var ampm = hours >= 12 ? 'PM' : 'AM';
		hours = hours % 12;
		hours = hours ? hours : 12; // the hour '0' should be '12'
		minutes = minutes < 10 ? '0' + minutes : minutes;
		var strTime = hours + ':' + minutes + ' ' + ampm;
		return strTime;
	}

	//-- No use time. It is a javaScript effect.
	function insertChat(who, text, time) {
		if (time === undefined) {
			time = 0;
		}
		var control = "";
		var date = formatAMPM(new Date());
		
		//실질적으로 채팅 뿌려주는 코드.
		if (who == "me") {
			control = '<li style="width:100%">'
					+ '<div class="msj macro">'
					+  '<div class="text text-l">'
					+ '<p>' + text + '</p>' + '<p><small>' + date
					+ '</small></p>' + '</div>' + '</div>' + '</li>';
		} else {
			control = '<li style="width:100%;">'
					+ '<div class="msj-rta macro">'
					+ '<div class="text text-r">'
					+ '<p>'
					+ text
					+ '</p>'
					+ '<p><small>'
					+ date
					+ '</small></p>'
					+ '</div>'
					+ '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:100%;" src="'
					+ you.avatar + '" /></div>' + '</li>';
		}
		setTimeout(function() {
			$("ul").append(control).scrollTop($("ul").prop('scrollHeight'));
		}, time);

	}

	function resetChat() {
		$("ul").empty();
	}

	//-- Clear Chat
	resetChat();

	//-- Print Messages
	//insertChat("me", "Hello Tom...", 0);
	//insertChat("you", "Hi, Pablo", 1500);
	//insertChat("me", "What would you like to talk about today?", 3500);
	//insertChat("you", "Tell me a joke", 7000);
	//insertChat("me", "Spaceman: Computer! Computer! Do we bring battery?!",
	//		9500);
	//insertChat("you", "LOL", 12000);

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