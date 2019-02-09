package kogile.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/list")
	public List<ProjectVO> list() {
		int total_m_no = (int)session.getAttribute("total_m_no");
		
		log.info("Pjt List-----------");
		log.info("total_m_no : " + total_m_no);
		List<ProjectVO> list = service.list(total_m_no); 
		return list;
	}
	
	@PostMapping("/insert")
	public ProjectVO insert(ProjectVO project) {
		project.setTotal_m_no((int)session.getAttribute("total_m_no"));
		log.info(project);
		
		service.insert(project);
		return project;
	}
}
