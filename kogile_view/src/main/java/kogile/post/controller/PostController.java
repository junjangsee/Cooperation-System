package kogile.post.controller;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kogile.post.domain.PostDetailVO;
import kogile.post.domain.PostVO;
import kogile.post.service.PostService;
import kogile.project.domain.CardVO;
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
	
	//설명이 보여진다
	@GetMapping(value="description/{p_no}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<PostVO> showDescription(@PathVariable("p_no") int p_no){
		log.info("설명이 보여진다@@@@@@@@@@@@@@@@@");
		log.info("피엔오는몇이니"+p_no);
		return new ResponseEntity<>(service.showDescription(p_no), HttpStatus.OK);
	}
	
	//설명이 수정된다
	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},value="description/{p_no}",
			consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modifyDescription(@PathVariable("p_no") int p_no,
			@RequestBody PostVO vo){
		vo.setP_no(p_no);
		
		return service.modifyDescription(vo)==1? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@PostMapping("/insertPost")
	public PostVO insertPost(PostVO post){
		
		System.out.println("post : " + post);
		
		post.setP_position(1);
		
		service.insertPost(post);
		
		return post;
		
	}


	@GetMapping("/detail/{p_no}")
	public PostVO detailPost(@PathVariable int p_no) {
		
		PostVO post = service.detailPost(p_no);

		System.out.println("detailPost");
		System.out.println("p_no : " + post);
		
		return post;
	}
	
	
	@PostMapping("/deletePost")
	public int deletePost(int p_no) {
		
		return service.deletePost(p_no); 
	}
	
	@RequestMapping(value="/updatePost", method={RequestMethod.POST})
	public void updateDate(@RequestBody PostVO post) {
		System.out.println(post.getDate() + "--------------------------");
		  service.updateDate(post);	
	}
	
}
