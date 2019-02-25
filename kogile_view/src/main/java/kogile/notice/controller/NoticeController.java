package kogile.notice.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kogile.invite.domain.InviteVO;
import kogile.label.domain.LabelVO;
import kogile.notice.domain.NoticeVO;
import kogile.notice.service.NoticeService;
import kogile.post.domain.PostVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/notice/*")
@AllArgsConstructor
public class NoticeController {
	
	private NoticeService service;
	
	private HttpSession session;
	
	@GetMapping(value = "/noticeList/{notice}")
	public ResponseEntity<List<NoticeVO>> invite() {
		int total_m_no = (int)session.getAttribute("total_m_no");
		System.out.println("total_m_no : " + total_m_no);
		
		List<NoticeVO> list = service.notice(total_m_no);
		System.out.println("list : " + list);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/ntcUpdate")
	public ResponseEntity<String> ntcUpdate(@RequestBody NoticeVO notice) {
		return service.ntcUpdate(notice) == 1 ? new ResponseEntity<>("�꽦怨�", HttpStatus.OK)
				: new ResponseEntity<>("�떎�뙣", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
