package kogile.project.mapper;

import java.util.List;

import kogile.invite.domain.InviteVO;
import kogile.project.domain.CardVO;
import kogile.project.domain.DragVO;
import kogile.project.domain.Prj_infoVO;
import kogile.project.domain.ProjectVO;
import kogile.project.domain.UserVO;

public interface ProjectMapper {
	
	public List<ProjectVO> list(int total_m_no);
	public int insert(ProjectVO project);
	public int insert_invite(InviteVO invite);
	public int insert_prjinfo(Prj_infoVO prj_info);
	public int insert_card(int pjt_no);
	public int drag_post(DragVO drag);
	public ProjectVO project_info(int pjt_no);
	public int modify(ProjectVO project);
	public UserVO master_info(int total_m_no);
	public int delete(int pjt_no);
}
