package kogile.invite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kogile.invite.domain.SearchVO;
import kogile.invite.service.InviteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/invite/*")
@AllArgsConstructor
public class InviteController {
	
	private InviteService service;
	
	@GetMapping("/searchList")
	public void searchList(Model model, @RequestParam SearchVO search){
		
		log.info("searchList");
		model.addAttribute("searchList", service.searchList(search));
	}
	
}
