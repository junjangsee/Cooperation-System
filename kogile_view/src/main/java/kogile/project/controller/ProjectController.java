package kogile.project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping("/profilePic")
	public ResponseEntity<String> profilePic(MultipartFile[] uploadProfile) {
		String uploadFolder = "/Users/bbongrack/Downloads/upload";
		//make folder
		File uploadPath = new File(uploadFolder, getFolder());
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile multipartFile : uploadProfile) {
			
			String uploadFilename = multipartFile.getOriginalFilename();
//		 IE 는 경로를 가진다. ~~\\파일명 이런식으로
			uploadFilename = uploadFilename.substring(uploadFilename.lastIndexOf("\\") + 1);
			
			UUID uuid = UUID.randomUUID();
			uploadFilename = uuid.toString() + "_" + uploadFilename;
			
			File saveFile = new File(uploadPath, uploadFilename);
			
			try {
				multipartFile.transferTo(saveFile);
				
			} catch (Exception e) {
				System.out.println(e);
			}//end try
			
//			if(checkImageType(saveFile)) {
//				FileOutputStream thumbnail = new FileOutputStream(new File())
//			}
			
		} //end for
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
		
	}
}
