package kogile.project.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kogile.project.domain.ProjectVO;
import kogile.project.domain.UserVO;
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
		int pjt_no = (int)session.getAttribute("pjt_no");
		return "redirect:/kogile/project/config?pjt_no="+pjt_no;
	}
	
	@GetMapping(value="/delete", produces= "application/text; charset=UTF-8")
	public ResponseEntity<String> delete()throws Exception{
		String emessage = "프로젝트 마스터가 아닙니다.";
		int pjt_no = (int)session.getAttribute("pjt_no");
		int master = service.project_info(pjt_no).getTotal_m_no();
		if(master == (int)session.getAttribute("total_m_no")) {
			service.delete(pjt_no);
			return new ResponseEntity<>("success", HttpStatus.OK);			
		}else {
			return new ResponseEntity<>(emessage, HttpStatus.BAD_REQUEST);
//			throw new Exception("프로젝트 마스터가 아닙니다.");
		}
	}
	
	@GetMapping("/config")
	public void config(int pjt_no, Model model) {
		ProjectVO project = service.project_info(pjt_no);
		model.addAttribute("project", project);
		UserVO master = service.master_info(project.getTotal_m_no());
		model.addAttribute("master", master);
	}
	
	
}
