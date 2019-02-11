package kogile.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kogile.project.domain.ProjectVO;
import kogile.project.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/kogile/project/*")
public class ProjectController2 {
	
	private ProjectService service;
	
	private HttpSession session;
	
	@PostMapping("/modify")
	public String modify(ProjectVO project) {
		service.modify(project);
		return "redirect:/kogile/startPage";
	}
	
	@PostMapping("/delete")
	public String delete() {
		int pjt_no = (int)session.getAttribute("pjt_no");
		service.delete(pjt_no);
		return "redirect:/kogile/startPage";
	}
}
