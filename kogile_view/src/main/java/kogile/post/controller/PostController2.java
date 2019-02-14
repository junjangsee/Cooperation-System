package kogile.post.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kogile.post.service.PostService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/kogile/*")
public class PostController2 {
	PostService service;
	HttpSession session;
	
	@GetMapping("/main_post")
	public void main_post() {
		
	}
}
