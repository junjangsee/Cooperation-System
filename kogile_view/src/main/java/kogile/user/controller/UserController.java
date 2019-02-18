package kogile.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.user.service.Sha256Hash;
import kogile.user.service.UserServiceInpl;
import lombok.Setter;

@RestController
@RequestMapping("/login/internal")
public class UserController {
//1) 회원가입
//2) 로그인
//3) 로그아웃
	@Setter(onMethod_={@Autowired})
	private UserServiceInpl service;
	
	@PostMapping("/register")
	public void interMemRegister(@RequestBody Map<String, String> userInfo){
		String encrypedPw = Sha256Hash.sha256(userInfo.get("password"));
		userInfo.replace("password", encrypedPw);
		System.out.println(userInfo);
	}
	
	@PostMapping("/login")
	public void interMemLogin() {
		
	}
	
	@PostMapping("/logOut")
	public void interMemLogout() {
		
	}
}
