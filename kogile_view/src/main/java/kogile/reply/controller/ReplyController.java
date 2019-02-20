package kogile.reply.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.UserVO;
import kogile.reply.domain.ReplyVO;
import kogile.reply.domain.TagVO;
import kogile.reply.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/kogile/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	private HttpSession session;
	
	//댓글작성
	@PostMapping(value = "/reply/new",consumes="application/json", 
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> createReply(@RequestBody ReplyVO vo){
		InviteVO invite = new InviteVO();
		invite.setPjt_no((int)session.getAttribute("pjt_no"));
		invite.setTotal_m_no((int)session.getAttribute("total_m_no"));
		int info_no = service.writer_info(invite);
		
		vo.setInfo_no(info_no);
		log.info("@@@@@ReplyVO@@@@@"+vo);
		int insertCount = service.registerReply(vo);
		log.info("글 들어간 갯수 = "+insertCount);
		
		System.out.println(info_no);
		
		return insertCount==1? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//댓글목록보기
	@GetMapping(value="/reply/{p_no}",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ReplyVO>> showListReply(@PathVariable("p_no") int p_no){
		log.info("showList@@@@@@@@@@@@@@@@@@@@@@@");
		
		return new ResponseEntity<>(service.replyList(p_no),HttpStatus.OK);
	}
	//댓글삭제
	@DeleteMapping(value="/reply/{r_no}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeReply(@PathVariable("r_no") int r_no){
		log.info("removeReply@@@@@@@@@@@@@@");
		int deleteCount = service.removeReply(r_no);
		
		return deleteCount==1? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//댓글수정
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, value="/reply/{r_no}",
			consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modifyReply(@RequestBody ReplyVO vo, @PathVariable("r_no") int r_no){
		vo.setR_no(r_no);
		log.info("댓글번호"+ r_no);
		int modifyCount = service.modifyReply(vo);
		
		return modifyCount==1? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//태그하기
	@PostMapping(value = "/tag/new",consumes="application/json", 
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> createTag(@RequestBody TagVO vo){
		log.info("@@@@@createTag@@@@@"+vo);
		int r_no= service.replyNum();
		vo.setR_no(r_no);
		int insertCount = service.registerTag(vo);
		log.info("태그 들어간 갯수 = "+insertCount);
		
		
		return insertCount==1? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//태그대상보기
			@GetMapping(value="/tag/{term}",
					produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<List<TagVO>> showTagMember(@PathVariable("term") String term){
				System.out.println(term);
				log.info("showList@@@@@@@@@@@@@@@@@@@@@@@");
				int pjt_no = (int)session.getAttribute("pjt_no");
				List<TagVO> fullList = service.tagList(pjt_no);
				
				List<TagVO> resList = new ArrayList<TagVO>();
				for(TagVO tag : fullList) {
					
					if(tag.getName().indexOf(term) != -1) {
						resList.add(tag);
						System.out.println(tag.getName());
					}
				}
				return new ResponseEntity<>(resList,HttpStatus.OK);
			}
		//태그알람보내기
		@PostMapping(value = "/tag/notice", consumes="application/json",
				produces= {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> createTagNotice(@RequestBody TagVO vo){
			log.info("@@@@@@createTagNotice@@@@@@"+vo);
			int tag_no = service.tagNum();
			vo.setTag_no(tag_no);
			
			int insertCount = service.insertTagNotice(vo);
			
			return insertCount==1? new ResponseEntity<>("success", HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
