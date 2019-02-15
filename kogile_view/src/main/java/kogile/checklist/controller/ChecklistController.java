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
	@GetMapping(value = "/pages/{p_no}/{page}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<List<ChecklistVO>> getList(
			@PathVariable("page") int page,
			@PathVariable("p_no") int p_no
			){
		log.info("getList....");
		
		Criteria cri = new Criteria(page, 3);
		
		log.info("cri 출력:" + cri);
		return new ResponseEntity<>(service.getList(cri, p_no),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{checklist_no}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE
	})
	public ResponseEntity<ChecklistVO> get(@PathVariable("checklist_no") int checklist_no){
		log.info("get: " + checklist_no);
		return new ResponseEntity<>(service.get(checklist_no), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{checklist_no}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("checklist_no") int checklist_no){
		
		log.info("remove" + checklist_no);
		
		return service.remove(checklist_no) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, 
				value = "/{checklist_no}",
				consumes = "application/json",
				produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(
							@RequestBody ChecklistVO cvo,
							@PathVariable("checklist_no") int checklist_no){
		
					cvo.setChecklist_no(checklist_no);
					log.info("checklist_no" + checklist_no);
					log.info("modify" + cvo);
					
					return service.modify(cvo) == 1
							? new ResponseEntity<>("success", HttpStatus.OK)
							: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
