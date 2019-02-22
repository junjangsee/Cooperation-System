package kogile.checklist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kogile.checklist.domain.ChecklistVO;
import kogile.checklist.domain.Criteria;
import kogile.checklist.domain.ListVO;
import kogile.checklist.service.ChecklistService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/kogile/checklist/*")
@RestController
@Log4j
@AllArgsConstructor
public class ChecklistController {
	
	private ChecklistService service;
	
	@PostMapping("/new")
	public int create(@RequestBody ChecklistVO cvo){
		
		log.info("ChecklistVO insert:" + cvo);
		
		int insertCount = service.register(cvo);
		
		log.info("Checklist Insert Count:" + insertCount);
		
		return insertCount;
	}
	
	// 특정 post 내용 조회 
	@GetMapping(value = "/readChecklist/{p_no}")
	public ResponseEntity<List<ChecklistVO>> getList(@PathVariable("p_no") int p_no){
		log.info("getList....");
		
		return new ResponseEntity<>(service.getList(p_no),HttpStatus.OK);
	}
	
//	@GetMapping(value = "/{checklist_no}",
//			produces = {
//					MediaType.APPLICATION_XML_VALUE,
//					MediaType.APPLICATION_JSON_UTF8_VALUE
//	})
//	public ResponseEntity<ChecklistVO> get(@PathVariable("checklist_no") int checklist_no){
//		log.info("get: " + checklist_no);
//		return new ResponseEntity<>(service.get(checklist_no), HttpStatus.OK);
//	}
	
	
	@GetMapping(value = "delete_check/{checklist_no}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("checklist_no") int checklist_no){
		
		log.info("remove" + checklist_no);
		
		return service.remove(checklist_no) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/update", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ChecklistVO cvo){
					
			return service.modify(cvo) == 1
					? new ResponseEntity<>("success", HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/insertList", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertList(@RequestBody ListVO list){
		return service.insertList(list) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/listList/{checklist_no}")
	public List<ListVO> listList(@PathVariable int checklist_no){
		return service.listList(checklist_no);
	}
	
	@GetMapping(value="/deleteList/{list_no}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteList(@PathVariable int list_no){
		return service.deleteList(list_no) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/updateList", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateList(@RequestBody ListVO list){
		return service.updateList(list) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/updateCheck", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateCheck(@RequestBody ListVO list){
		return service.updateCheck(list) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/percent/{checklist_no}")
	public ChecklistVO percent(@PathVariable int checklist_no) {
		
		int percent = service.percent(checklist_no);
		ChecklistVO check = new ChecklistVO();
		check.setChecklist_no(checklist_no);
		check.setCompletePercent(percent);
		
		return check;
	}
	
}
