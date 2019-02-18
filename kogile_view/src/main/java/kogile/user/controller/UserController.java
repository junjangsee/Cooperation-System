package kogile.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.user.domain.UserVO;
import kogile.user.service.Sha256Hash;
import kogile.user.service.UserServiceInpl;
import lombok.Setter;

@RestController
@RequestMapping("/login/internal")
public class UserController {

	@Setter(onMethod_={@Autowired})
	private UserServiceInpl service;
	
	@PostMapping("/register")
	public void interMemRegister(@RequestBody Map<String, String> userInfo){
		System.out.println("register...");
		service.interMemRegister(userInfo);
	}
	
	@PostMapping("/login")
	public void interMemLogin(@RequestBody Map<String, String> userInfo, HttpServletRequest request, HttpServletResponse response){
		System.out.println("login...");
		service.interMemLogin(userInfo, request, response);
	}
	
	@PostMapping("/logOut")
	public void interMemLogout(HttpServletRequest request) {
		System.out.println("logout...");
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
