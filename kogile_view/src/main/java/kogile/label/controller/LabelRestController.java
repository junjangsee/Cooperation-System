package kogile.label.controller;

import java.util.ArrayList;
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
	
	@GetMapping(value="delete/{label_no}")
	public ResponseEntity<String> deleteLabel(@PathVariable int label_no){
		System.out.println("delete label_no : " + label_no);
		return service.deleteLabel(label_no) == 1 ? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>("실패", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("update")
	public ResponseEntity<String> updateLabel(@RequestBody LabelVO label) {
		return service.updateLabel(label) == 1 ? new ResponseEntity<>("성공", HttpStatus.OK)
				: new ResponseEntity<>("실패", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("listLabelInfo/{p_no}")
	public List<LabelVO> listLabelInfo(@PathVariable int p_no){
		List<LabelVO> list_LabelInfo = service.listLabelInfo(p_no);
		List<LabelVO> list = new ArrayList<>();
		for(int i = 0; i < list_LabelInfo.size(); i ++) {
			int label_no = list_LabelInfo.get(i).getLabel_no();
			list.add(service.detailLabel(label_no));
		}
//		List<LabelVO> list = 
		return list;
	}	
	
	@PostMapping("selectLabel")
	public ResponseEntity<String> selectLabel(@RequestBody LabelVO label){
		return service.selectLabel(label) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping("cancelLabel")
	public ResponseEntity<String> clanelLabel(@RequestBody LabelVO label_info){
		return service.cancelLabel(label_info) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
