package kogile.label.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.label.domain.LabelVO;
import kogile.label.service.LabelService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/kogile/label/*")
@AllArgsConstructor
public class LabelRestController {
	private LabelService service;
	
	private HttpSession session;
	
	@GetMapping("list")
	public List<LabelVO> list(){
		int pjt_no = (int)session.getAttribute("pjt_no");
		List<LabelVO> list = service.listLabel(pjt_no);
		return list;
	}
}
