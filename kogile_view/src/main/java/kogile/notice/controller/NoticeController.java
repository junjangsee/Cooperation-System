package kogile.notice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.notice.domain.NoticeVO;
import kogile.notice.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/notice/*")
@AllArgsConstructor
public class NoticeController {
	
	private NoticeService service;
	
	@GetMapping(value = "/noticeList/{notice}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<NoticeVO>> invite(@PathVariable("notice") int notice) {

		List<NoticeVO> list = service.notice(notice);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
