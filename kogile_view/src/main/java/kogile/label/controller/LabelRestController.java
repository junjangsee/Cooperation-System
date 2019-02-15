package kogile.label.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("insert")
	public int insertLabel(@RequestBody LabelVO label) {
		int pjt_no = (int)session.getAttribute("pjt_no");
		label.setPjt_no(pjt_no);
		service.insertLabel(label);
		return pjt_no;
	}
	
	@GetMapping("detail/{label_no}")
	public LabelVO detailLabel(@PathVariable int label_no) {
		LabelVO label = service.detailLabel(label_no);
		return label;
	}
}
