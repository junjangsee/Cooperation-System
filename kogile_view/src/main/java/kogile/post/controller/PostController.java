package kogile.post.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.post.domain.PostDetailVO;
import kogile.post.domain.PostVO;
import kogile.post.service.PostService;
import kogile.project.domain.CardVO;
import kogile.reply.domain.ReplyVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/kogile/post/*")
public class PostController {
	
	private PostService service;
	private HttpSession session;
	
	@GetMapping("/list_card")
	public List<CardVO> list_card(){
		System.out.println("list_card");
		int pjt_no = (int)session.getAttribute("pjt_no");
		System.out.println("pjt_no : " + pjt_no);
		List<CardVO> list = service.list_card(pjt_no);
		return list;
	}
	
	@GetMapping("/list_post")
	public List<PostVO> list_post(){
		System.out.println("list_post");
		int pjt_no = (int)session.getAttribute("pjt_no");
		List<PostVO> list = service.list_post(pjt_no);
		
		return list;
	}

	@PostMapping("/insertPost")
	public PostVO insertPost(PostVO post){
		System.out.println("post : " + post);
		
		post.setP_position(1);
		
		service.insertPost(post);
		
		return post;
		
	}

	@GetMapping("/{p_title}")
	public List<PostDetailVO> detailPost(@PathVariable("p_title") int p_no) {
		
		PostDetailVO postDetailVO = new PostDetailVO();
		
		List<PostDetailVO> list = service.detailPost(p_no);
		
		return list;
	}

	
}
