package kogile.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kogile.project.domain.CardVO;
import kogile.project.domain.ProjectVO;
import kogile.project.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
@RequestMapping("/kogile/project/*")
public class ProjectController {
	
	private ProjectService service;
	
	private HttpSession session;
	
	@GetMapping("/list_project")
	public List<ProjectVO> list() {
		int total_m_no = (int)session.getAttribute("total_m_no");
		
		System.out.println("list project");
		System.out.println("total_m_no : "+ total_m_no);
		List<ProjectVO> list = service.list(total_m_no); 
		return list;
	}
	
	@PostMapping("/insert")
	public ProjectVO insert(String pjt_title, String pjt_contents) {
		ProjectVO project = new ProjectVO();

		project.setPjt_title(pjt_title);
		project.setPjt_contents(pjt_contents);
		
		project.setTotal_m_no((int)session.getAttribute("total_m_no"));
		log.info(project);
		
		service.insert(project);
		return project;
	}
	
	@GetMapping("/list_card")
	public List<CardVO> list_card(){
		int pjt_no = (int)session.getAttribute("pjt_no");
		System.out.println("pjt_no : " + pjt_no);
		List<CardVO> list = service.list_card(pjt_no);
		return list;
	}
}
