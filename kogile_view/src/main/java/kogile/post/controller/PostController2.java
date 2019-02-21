package kogile.post.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kogile.post.domain.PostVO;
import kogile.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/kogile/post*")
public class PostController2 {

	PostService service;
	
	HttpSession session;
	
	@GetMapping("/detailPost/{p_no}")
	public String main_post(@PathVariable int p_no, Model model) {

		PostVO post = service.detailPost(p_no);
		
		model.addAttribute("post", post);
		
		return "kogile/post/detailPost";
	}
}
