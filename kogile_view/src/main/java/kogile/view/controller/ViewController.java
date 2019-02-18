package kogile.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kogile.user.domain.UserVO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/kogile/*")
@Log4j
public class ViewController {
	
	private HttpSession session;
	
	@GetMapping("/login")
	public void login() {
		
	};
	@GetMapping("/register")
	public void register() {
		
	};
	
	@RequestMapping("/startPage")
	public void start() {
		
	}
	
	@GetMapping("/main")
	public void main() {

	}
	
	@GetMapping("/main_configure")
	public void configure() {
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		String path = "";
		UserVO user = (UserVO) request.getAttribute("user");
		if(user.isInterMem()){
			path = "/login/internal/logout";
		}else{
			path = "/login/external/logoutKogileWithKakao";
		}
		
		return "redirect"+ path;
	}

}
