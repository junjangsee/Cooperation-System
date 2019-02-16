package kogile.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kogile.project.domain.CardVO;
import kogile.project.domain.DragVO;
import kogile.project.domain.ProjectVO;
import kogile.project.domain.UserVO;
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
		List<ProjectVO> list = service.list(total_m_no); 
//		log.info(list);
		return list;
	}
	
	@PostMapping("/insert")
	public ProjectVO insert(ProjectVO project) {

		project.setTotal_m_no((int)session.getAttribute("total_m_no"));
//		log.info(project);
		
		service.insert(project);
		return project;
	}
	
	@PostMapping("/drag_post")
	public void drag(int new_c_no, int p_no) {
		DragVO drag = new DragVO();
		drag.setNew_c_no(new_c_no);
		drag.setP_no(p_no);
		service.drag_post(drag);
	}
	
	@GetMapping("/project_info")
	public ProjectVO project_info() {
		int pjt_no = (int)session.getAttribute("pjt_no");
		ProjectVO project = service.project_info(pjt_no);
		log.info(project);
		return project;
	}
	
	@GetMapping("/master_info")
	public UserVO master_info() {
		int total_m_no = (int)session.getAttribute("total_m_no");
		UserVO master = service.master_info(total_m_no);
		return master;
	}
	
}
