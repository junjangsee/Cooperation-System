package kogile.post.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import kogile.post.domain.PostVO;
import kogile.post.service.PostService;
import kogile.project.domain.CardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
@SessionAttributes("pjt_no")
@RequestMapping("/kogile/post/*")
public class PostController {

	private PostService service;

	// 카드 내역 출력
	@GetMapping("/list_card")
	public List<CardVO> list_card(@ModelAttribute("pjt_no") int pjt_no) {
		System.out.println("list_card");
		System.out.println("pjt_no : " + pjt_no);
		List<CardVO> list = service.list_card(pjt_no);
		return list;
	}

	// 카드에 포스트 내역 출력
	@GetMapping("/list_post")
	public List<PostVO> list_post(@ModelAttribute("pjt_no") int pjt_no) {
		System.out.println("list_post");
		List<PostVO> list = service.list_post(pjt_no);

		return list;
	}

	// 설명이 보여진다
	@GetMapping(value = "description/{p_no}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PostVO> showDescription(@PathVariable("p_no") int p_no) {

		return new ResponseEntity<>(service.showDescription(p_no), HttpStatus.OK);
	}

	// 설명이 수정된다
	@RequestMapping(method = { RequestMethod.PUT,
			RequestMethod.PATCH }, value = "description/{p_no}", consumes = "application/json", produces = {
					MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modifyDescription(@PathVariable("p_no") int p_no, @RequestBody PostVO vo) {
		vo.setP_no(p_no);

		return service.modifyDescription(vo) == 1 ? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 포스트 삽입
	@PostMapping("/insertPost")
	public PostVO insertPost(PostVO post) {

		System.out.println("post : " + post);

		post.setP_position(1);

		service.insertPost(post);

		return post;

	}

	// 포스트 내용 보기
	@GetMapping("/detail/{p_no}")
	public PostVO detailPost(@PathVariable int p_no) {

		PostVO post = service.detailPost(p_no);

		return post;
	}

	// 포스트 삭제
	@PostMapping("/deletePost")
	public int deletePost(int p_no) {

		return service.deletePost(p_no);
	}

	// 포스트 제목 수정
	@RequestMapping(value = "/updatePostTitle", method = { RequestMethod.PATCH })
	public int updatePostTitle(@RequestBody PostVO post) {
				
		return service.updatePostTitle(post);
	}

	// 포스트 날짜 수정
	@PostMapping(value = "/updatePostDate")
	public int updateDate(@RequestBody PostVO post) {

		return service.updatePostDate(post);
	}

}
