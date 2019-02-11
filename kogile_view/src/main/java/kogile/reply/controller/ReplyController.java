package kogile.reply.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.reply.domain.ReplyVO;
import kogile.reply.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/kogile/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	@PostMapping(value = "/reply/new",consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("@@@@@ReplyVO@@@@@"+vo);
		
		int insertCount = service.register(vo);
		
		log.info("글 들어간 갯수 = "+insertCount);
		
		return insertCount==1? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
