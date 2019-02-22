/**
 * 이메일, 패스워드, 닉네임을 입력받아서 입력값 체크를 합니다.
 */

var boundsChecking = {

	"email" : function(email) {
		console.log(encodeURIComponent(email));
		if(email.length < 0) {
			alert("이메일을 입력해 주세요.");
			return false;
		}
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(email.match(regExp) == null) {
			alert("올바른 이메일을 입력해 주세요.");
			return false;
		}
		
		$.ajax({
			type : 'get',
			url : '/login/internal/isAlreadMember/' + email + '/',
			success : function(result, status, xhr){
				if(result == 'T'){
					alert("이미 가입된 아이디입니다!");
					return false;
				}
			},
			error : function(error) {
				error(er);
			}
		})
		return true;
	},
	
	"password" : function(password) {
		if (password.length < 8 || password.length > 20) {
			alert("8자리~ 20자리 이내로 입력해 주세요.");
			return false;
		}
		if (password.search(/\s/) != -1) {
			alert("비밀번호에 공백을 입력 할 수 없습니다.");
			return false;
		}
		var num = password.search(/[0-9]/g); // 숫자의 위치. 없으면 -1
		var eng = password.search(/[a-z]/ig); // 영문자의 위치. 없으면 -1.
		var spe = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);// 특수문자의 위치.
																	// 없으면 -1.

		if (num < 0 || eng < 0 || spe < 0) {
			alert("영문,숫자,특수문자를 1자이상 혼합하여 입력해 주세요.");
			return false;
		}

		return true;
	},
	
	"name" : function(name) {
		if(name.length < 2 || name.length > 20) {
			alert("이름은 2자이상 20자 이하여야 합니다.");
			return false;
		}
		var spe = name.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		
		if(spe >= 0) {
			alert("이름에는 특수문자를 입력 할 수 없습니다.");
			return false;
		}
		return true;
	}
};