package kogile.invite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;
import kogile.invite.service.InviteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController //***
//@Controller
@Log4j
@RequestMapping("/invite/")
@AllArgsConstructor
public class InviteController {
	
	private InviteService service;

/*	@GetMapping("/searchList")
	public void searchList(Model model, @RequestParam(value="search", required=false, defaultValue="0")String search2){
		
		SearchVO search = new SearchVO();
		search.setSearch(search2);
		
		List<SearchListVO> list = service.searchList(search);
		
		model.addAttribute("searchList", list);
		
	}*/
	
	//searchList 하나의 객체 json
/*	@GetMapping(value = "/searchList2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}) //*** ***:json 작업 중
	public SearchListVO searchList2(){
		
		return new SearchListVO(2, "스타", "로드");
	}
	
	//searchList 리스트 객체 json
	@GetMapping(value = "/searchList3") //*** ***:json 작업 중
	public List<SearchListVO> searchList3(){
		
		return IntStream.range(1, 10).mapToObj(i -> new SearchListVO(i, i + "First", i + " Last")).collect(Collectors.toList());
	}*/
	
	@GetMapping(value="/searchList/{search}", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<SearchListVO>> saerchList(@RequestBody SearchVO search2, @PathVariable("search") String search){
		log.info("searchVO................");
		
		search2 = new SearchVO();
		search2.setSearch(search);
		
		List<SearchListVO> list = service.searchList(search2);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	
	
}
