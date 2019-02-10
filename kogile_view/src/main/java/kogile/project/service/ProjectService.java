package kogile.project.service;

import java.util.List;

import kogile.project.domain.CardVO;
import kogile.project.domain.ProjectVO;

public interface ProjectService {
	public List<ProjectVO> list(int total_m_no);
	public void insert(ProjectVO project);
	public List<CardVO> list_card(int pjt_no);

}
