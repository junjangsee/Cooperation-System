package kogile.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kogile.user.domain.UserVO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/kogile/*")
@SessionAttributes({"pjt_no", "user", "total_m_no"})
@Log4j
public class ViewController {
	
	
	@GetMapping("/login")
	public void login() {
		
	};
	@GetMapping("/register")
	public void register() {
		
	};
	
	@RequestMapping("/startPage")
	public void start(@ModelAttribute("user") UserVO user, Model model) {
		System.out.println(user.getTotal_m_no());
		model.addAttribute("total_m_no", user.getTotal_m_no());
	}
	
	
	@GetMapping("/main")
	public String main(String pjt_no, Model model) {
		if(pjt_no != null) {
			model.addAttribute("pjt_no", Integer.parseInt(pjt_no));
		}else {
			return "redirect: /kogile/startPage";
		}
		return "/kogile/main";
	}
	
	@GetMapping("/main_configure")
	public void configure() {
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		String path = "";
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		if(user.isInterMem()){
			path = "/login/internal/logout";
		}else{
			path = "/login/external/logoutKogileWithKakao";
		}
		
		return "redirect:"+ path;
	}
	
	@GetMapping("/profile")
	public void profile() {
		
	}

}
