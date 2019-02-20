/**
 * user관련 Ajax모듈
 */
function UserVo(name, email, password) {
	this.name = name;
	this.email = email;
	this.password = password;
}

var userService = (function() {
	console.log('userModuletest..');
	var url = {
		"login" : "/login/internal/login",
		"register" : "/login/internal/register",
		"logout" : "/kogile/logOut"
	};

	//login. Map으로 login정보를 전달합니다.
	function login(loginInfo, callback, error) {
		$.ajax({
			type : 'post',
			url : url.login,
			data : JSON.stringify(loginInfo),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if(callback){
					callback(result);
				}
			},
			error : function(er) {
				if(error) {
					error(er);
				}
			}
		})
	}
	
	//register
	function register(registerInfo, callback, error) {
		$.ajax({
			type : 'post',
			url : url.register,
			data : JSON.stringify(registerInfo),
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
	
	//logout
	function logout(callback, error) {
		$.ajax({
			type : 'get',
			url : url.logout,
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
		"login" : login,
		"register" : register,
		"logout" : logout
	};
})();