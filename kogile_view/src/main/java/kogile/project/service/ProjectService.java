package kogile.project.service;

import java.util.List;

import kogile.project.domain.DragVO;
import kogile.project.domain.ProjectVO;
import kogile.project.domain.UserVO;

public interface ProjectService {
	public List<ProjectVO> list(int total_m_no);
	public void insert(ProjectVO project);
	public void drag_post(DragVO drag);
	public ProjectVO project_info(int pjt_no);
	public void modify(ProjectVO project);
	public UserVO master_info(int total_m_no);
	public void delete(int pjt_no);
	
	public void insertProjectLabel(int pjt_no);

}
