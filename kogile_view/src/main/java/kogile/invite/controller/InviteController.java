package kogile.invite.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kogile.invite.domain.SearchListVO;
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
	public void searchList(Model model, @RequestParam(value="search", required=false, defaultValue="0")String search2){
		
		SearchVO search = new SearchVO();
		search.setSearch(search2);
		
		List<SearchListVO> list = service.searchList(search);
		
		model.addAttribute("searchList", list);
		
	}
	
}
