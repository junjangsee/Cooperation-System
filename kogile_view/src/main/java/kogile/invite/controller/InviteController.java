package kogile.invite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kogile.invite.domain.InviteVO;
import kogile.invite.domain.SearchListVO;
import kogile.invite.domain.SearchVO;
import kogile.invite.service.InviteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController //***
//@Controller
@Log4j
@RequestMapping("/invite/*")
@AllArgsConstructor
public class InviteController {
	
	private InviteService service;
	private HttpSession session;
	
/*	@GetMapping("/searchList")
	public void searchList(Model model, @RequestParam(value="search", required=false, defaultValue="0")String search2){
		
		SearchVO search = new SearchVO();
		search.setSearch(search2);
		
		List<SearchListVO> list = service.searchList(search);
		
		model.addAttribute("searchList", list);
		
	}*/
	
	//searchList �ϳ��� ��ü json
/*	@GetMapping(value = "/searchList2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}) //*** ***:json �۾� ��
	public SearchListVO searchList2(){
		
		return new SearchListVO(2, "��Ÿ", "�ε�");
	}
	
	//searchList ����Ʈ ��ü json
	@GetMapping(value = "/searchList3") //*** ***:json �۾� ��
	public List<SearchListVO> searchList3(){
		
		return IntStream.range(1, 10).mapToObj(i -> new SearchListVO(i, i + "First", i + " Last")).collect(Collectors.toList());
	}*/
	
	@GetMapping(value="/searchList/{search}", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<SearchListVO>> searchList(@PathVariable("search") String search){
		
		SearchVO search2 = new SearchVO();
		search2.setSearch(search);
		
		List<SearchListVO> list = service.searchList(search2);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/searchPjt/{search}/{total_m_no}", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<SearchListVO>> searchPjt(@PathVariable("search") String search, @PathVariable int total_m_no){
		
		SearchVO search2 = new SearchVO();
		search2.setSearch(search);
		search2.setTotal_m_no(total_m_no);
		
		List<SearchListVO> list = service.searchPjt(search2);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value="/inviteList")	//inivite�� js���� param.invite�� �ѱ� ��
	public ResponseEntity<List<InviteVO>> invite(){
		int pjt_no = (int)session.getAttribute("pjt_no");
		System.out.println("pjt_no : " + pjt_no);
		
		List<InviteVO> list = service.invite(pjt_no);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/new", 
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertInvite(@RequestBody InviteVO invite){
		
		log.info("InviteVO: " + invite);
		
		service.insertInvite(invite);
		
		return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/delete")
	public int deleteInvite(@RequestBody InviteVO invite) {
		
		return  service.deleteInvite(invite);
	}
	
	
}
